# KALI NEXUS Testing & Verification Guide

## 1. Automated Tests

Run JVM unit tests (app drawer filtering/sorting, JSON backup roundtrip):
```bash
./gradlew testDebugUnitTest
```

Run Android instrumentation tests on a connected device or emulator (verifies `CATEGORY_HOME` intent resolution and 5-section Compose navigation):
```bash
./gradlew connectedDebugAndroidTest
```

## 2. Manual On-Device Verification Checklist

### Default Launcher & Activity Lifecycle
- [ ] Assign **KALI NEXUS** as Default Home in **Settings → Apps → Default apps → Home app**.
- [ ] Open any third-party app, then press the system **Home** button/gesture → verify `MainActivity.onNewIntent()` returns directly to `HOME` Page 0 and closes the App Drawer if open.
- [ ] Press the system **Back** button on `HOME` Page 0 → verify the launcher does NOT close or fall back to the previous launcher.

### Home Screen & Customization
- [ ] Verify digital clock updates and respects 12h/24h + seconds toggles in **SETTINGS**.
- [ ] Swipe left/right across multiple home pages and check page indicators.
- [ ] Long-press empty home background → pin/unpin apps, toggle grid columns (`4x5` / `5x5`), toggle telemetry strip.
- [ ] Swipe up from Home or tap **ALL APPS** → App Drawer opens smoothly.

### App Drawer & Persistence
- [ ] Verify real installed app icons and labels load smoothly without stutter.
- [ ] Type in the search bar and tap the A–Z / Z–A sort toggle and right-edge letter rail.
- [ ] Long-press any app → test **Pin to Dock**, **Pin to Home Page**, **Favorite**, **Hide from Launcher**, **App Info**.
- [ ] Force-stop and reopen KALI NEXUS → verify DataStore restores theme, wallpaper, dock, favorites, pinned home apps, and hidden apps.
- [ ] Test **Export JSON** and **Restore JSON** in **SETTINGS**.

### Genuine Hardware Telemetry & Permissions
- [ ] Open **SYSTEM** → verify manufacturer, model, Android version, API level, RAM, storage, battery %, charging state, and network type match device Settings.
- [ ] Verify missing `PACKAGE_USAGE_STATS` permission does NOT crash the App Drawer; tapping **Enable Usage Access** opens Android's Usage Access screen cleanly.
