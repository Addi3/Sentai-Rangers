package com.addie.core;

import com.addie.SentaiRangers;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SentaiRangersSounds {

    // Morphs
    public static final SoundEvent ZYURANGER = register("morphs/zyuranger");

    // Register a SoundEvent
    private static SoundEvent register(String name) {
        Identifier id = SentaiRangers.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    // Initialize all sounds
    public static void init() {
        // This ensures the static fields are loaded and registered
    }
}