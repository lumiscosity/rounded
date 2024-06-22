package com.lumiscosity.rounded.misc;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static com.lumiscosity.rounded.Rounded.MOD_ID;

public class RegisterSounds {
    public static final Identifier TROUGH_FILL_ID = Identifier.of(MOD_ID, "trough_fill");
    public static final SoundEvent TROUGH_FILL = SoundEvent.of(TROUGH_FILL_ID);
    public static final Identifier TROUGH_CONSUME_ID = Identifier.of(MOD_ID, "trough_consume");
    public static final SoundEvent TROUGH_CONSUME = SoundEvent.of(TROUGH_CONSUME_ID);

    public static void initSounds() {
        Registry.register(Registries.SOUND_EVENT, TROUGH_FILL_ID, TROUGH_FILL);
        Registry.register(Registries.SOUND_EVENT, TROUGH_CONSUME_ID, TROUGH_CONSUME);
    }
}
