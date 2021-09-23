package com.github.m5rian.kotlingua

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object LangSerializer : KSerializer<Lang> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Lang", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Lang) = encoder.encodeString(value.iso)
    override fun deserialize(decoder: Decoder): Lang = Lang.values().first { it.iso == decoder.decodeString() }
}