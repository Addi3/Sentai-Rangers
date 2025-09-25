package com.addie;

import com.addie.core.SentaiRangersSounds;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentaiRangers implements ModInitializer {
	public static final String MOD_ID = "sentai-rangers";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        SentaiRangersSounds.init();

	}
}