# KALI NEXUS — Cyber Edition Android Launcher

KALI NEXUS is a native **Kotlin + Jetpack Compose** Android Home launcher designed for Android 10+ (API 29–35) without root access. It implements Android's `ACTION_MAIN` + `CATEGORY_HOME` intent contract so it can be selected as the device's default Home application.

## Project Structure

- `.github/workflows/build.yml` — Automated GitHub Actions cloud APK build (`ubuntu-latest`, JDK 17 Temurin, Gradle 8.9) producing the `kali-nexus-apk` artifact.
- `gradlew`, `gradlew.bat`, `gradle/wrapper/gradle-wrapper.properties` — Gradle 8.9 wrapper configuration.
- `app/src/main/AndroidManifest.xml` — `HOME` + `LAUNCHER` intent filters, Android 11+ `<queries>` package visibility, and non-root permissions.
- `app/src/main/java/com/kalinexus/launcher/MainActivity.kt` — `singleTask` launcher lifecycle, `onNewIntent` Home key handling, edge-to-edge rendering, and back-stack control.
- `app/src/main/java/com/kalinexus/launcher/viewmodel/LauncherViewModel.kt` — Reactive state coordination across installed apps, DataStore preferences, hardware telemetry, security checks, and weather.
- `app/src/main/java/com/kalinexus/launcher/data/`
  - `SettingsRepository.kt` — Jetpack DataStore Preferences persistence (including custom hex colors and local HTML widget URI).
  - `BackupManager.kt` — Validated JSON export/import via Android Storage Access Framework.
  - `WeatherRepository.kt` — Optional Open-Meteo weather fetch with offline standby fallback.
- `app/src/main/java/com/kalinexus/launcher/system/`
  - `AppDiscoveryManager.kt` — `LauncherApps` live package discovery, LRU icon caching, ADW/Nova icon pack `appfilter.xml` lookup, and `UsageStatsManager` recents.
  - `DeviceTelemetryProvider.kt` — Real hardware readings via `ActivityManager`, `StatFs`, `BatteryManager`, `ConnectivityManager`, `PowerManager`, and safe `/proc`/`/sys` checks.
  - `SecurityAuditProvider.kt` — `KeyguardManager`, `RoleManager`, and default launcher status.
- `app/src/main/java/com/kalinexus/launcher/ui/screens/`
  - `HomeScreen.kt` — Multi-page workspace, customizable clock, weather card, telemetry strip, toggleable local HTML/JS WebView widget card, dock, swipe-up drawer, and long-press customization.
  - `AppDrawerSheet.kt` — Search, A–Z / Z–A sorting, letter jump index, favorites, recently used, and hidden app restore.
  - `SystemScreen.kt` — Genuine hardware & Android OS dashboard + clearly separated conceptual ecosystem card.
  - `SecurityScreen.kt` — Real lock/VPN/default-home/usage-access checks, recent packages audit, and planned module roadmap.
  - `GamingScreen.kt` — Thermal/RAM/battery readiness, `CATEGORY_GAME` auto-discovery, manual game tagging, and planned module roadmap.
  - `SettingsScreen.kt` — Full customization including custom hex theme importer, local `.html` widget picker, and JSON backup/restore.

## Build & Testing Docs

- See `BUILD_AND_INSTALL.md` for Android Studio, Gradle CLI, and ADB APK installation instructions.
- See `TESTING_GUIDE.md` for unit tests, instrumentation tests, and default-launcher verification checklists.
