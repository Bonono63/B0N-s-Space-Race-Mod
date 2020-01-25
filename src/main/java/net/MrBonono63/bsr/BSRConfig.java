package net.MrBonono63.bsr;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonGrammar;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class BSRConfig {

        private static final Jankson JANKSON = Jankson.builder().build();

        public static void sync() {
                File configFile = new File("config/bsr.json5");
                JsonObject config = new JsonObject();
                if(configFile.exists()) {
                        try {
                                config = JANKSON.load(configFile);
                                loadFrom(config);
                                writeConfigFile(configFile, config);
                        } catch (IOException | SyntaxError e) {
                                BSR.LOGGER.error("BSR config could not be loaded. Default values will be used.", e);
                        }
                } else {
                        saveTo(config);
                        writeConfigFile(configFile, config);
                }
        }

        //deserializer
        public static void loadFrom(JsonObject obj) {
                JsonObject Dimensions = getObjectOrEmpty("Dimensions", obj);
                BSRDimensions.waterVaporizes = Dimensions.getBoolean("water_vaporizes", BSRDimensions.waterVaporizes);

                JsonObject useProgrammerArt = getObjectOrEmpty("useProgrammerArt", obj);

        }

        //serializer
        public static void saveTo(JsonObject obj) {
                JsonObject Dimensions = defaultPutButNotNull("Dimensions", new JsonObject(), obj);
                Dimensions.putDefault("water_vaporizes", BSRDimensions.waterVaporizes, "Changes whether or not water vaporizes in Space");
        }

        private static void writeConfigFile(File file, JsonObject config) {
                saveTo(config);
                try(OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
                        out.write(config.toJson(JsonGrammar.JANKSON).getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                        BSR.LOGGER.error("BSR config could not be written. This probably won't cause any problems, but it shouldn't happen.", e);
                }
        }
        public static class BSRDimensions {
                public static boolean waterVaporizes = false;
        }

        private static JsonObject getObjectOrEmpty(String key, JsonObject on) {
                JsonObject obj = on.getObject(key);
                return obj != null ? obj : new JsonObject();
        }

        @SuppressWarnings("unchecked")
        private static <T extends JsonElement> T defaultPutButNotNull(String key, T value, JsonObject obj) {
                JsonElement result = obj.putDefault(key, value, value.getClass(), null);
                return result != null ? (T) result : value;
        }
}
