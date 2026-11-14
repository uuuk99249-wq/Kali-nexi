# Keep kotlinx.serialization models for DataStore backup/restore
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keep,includedescriptorclasses class com.kalinexus.launcher.model.**$$serializer { *; }
-keepclassmembers class com.kalinexus.launcher.model.** {
    *** Companion;
}
-keepclasseswithmembers class com.kalinexus.launcher.model.** {
    kotlinx.serialization.KSerializer serializer(...);
}
