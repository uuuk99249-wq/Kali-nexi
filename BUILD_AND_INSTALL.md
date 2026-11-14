# Building & Installing the KALI NEXUS APK

## Option 1: Build APK Directly From Your Phone (GitHub Actions Cloud Build — No PC Required)

You can compile `app-debug.apk` in the cloud using only your Android phone's browser and GitHub's free Actions runner:

1. **Download & Extract the Project ZIP**
   - Tap **Download Android Project** in the KALI NEXUS explorer to save `kali-nexus-launcher-android.zip` to your phone's `Downloads` folder.
   - Open your phone's Files app and extract the ZIP so you have the `kali-nexus-launcher/` folder.

2. **Create a GitHub Repository on Your Phone**
   - Open `https://github.com` in Chrome (or your mobile browser) and sign in.
   - Tap **+** → **New repository**, name it `kali-nexus-launcher`, and create it.

3. **Upload the Project Contents to GitHub**
   - On the empty repository page, tap **uploading an existing file** (or **Add file → Upload files**).
   - **Important:** Upload the **contents inside** `kali-nexus-launcher/` so that `.github/workflows/build.yml`, `build.gradle.kts`, `settings.gradle.kts`, and `app/` sit at the **root** of your GitHub repository.
   - *(Tip for mobile browsers: if your Android file picker hides dot-folders like `.github`, switch to **Desktop site** or create `.github/workflows/build.yml` via **Add file → Create new file** and paste the workflow from this project.)*
   - Tap **Commit changes**.

4. **Download the Compiled APK from GitHub Actions**
   - Tap the **Actions** tab at the top of your repository.
   - Select the **Build KALI NEXUS Debug APK** workflow run (or tap **Run workflow** to trigger it manually).
   - Once the green checkmark appears (~2–4 minutes), scroll to the **Artifacts** section at the bottom of the run summary.
   - Tap **`kali-nexus-apk`** to download the ZIP containing `app-debug.apk`.
   - Extract `app-debug.apk` in your Files app and tap it to install on your phone (enable *Install unknown apps* if prompted).

---

## Option 2: Build & Run via Android Studio (Desktop)

- **Android Studio**: Ladybug (2024.2.1) or newer
- **JDK**: Java 17 (Temurin or Android Studio JetBrains Runtime)
- **Android SDK**: Platform API 35 (`compileSdk = 35`), Minimum target device Android 10 (API 29+)

1. Open Android Studio and choose **File → Open**.
2. Select the `kali-nexus-launcher` folder.
3. Wait for Gradle Sync to download dependencies (`libs.versions.toml` + `gradle-wrapper.properties` using Gradle 8.9).
4. Connect an Android 10+ phone with **USB Debugging** enabled (or launch an API 29–35 Emulator).
5. Click **Run (`Shift+F10`)**.

---

## Option 3: Build via Command Line & ADB

From inside `kali-nexus-launcher/`:

```bash
# Using Gradle 8.9 directly (or after running `gradle wrapper --gradle-version 8.9`):
gradle assembleDebug

# Output location:
# app/build/outputs/apk/debug/app-debug.apk

# Install over USB via ADB:
adb devices
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

---

## Setting KALI NEXUS as Default Home Launcher

1. Open **KALI NEXUS** from your app drawer.
2. Tap **Set Default** on the Home banner (or open **SETTINGS → Set as Default Launcher**).
3. On Android 10+, the system `RoleManager` dialog prompts you to select **KALI NEXUS** as your Home app.
4. Alternatively, go to **Android Settings → Apps → Default apps → Home app** and select **KALI NEXUS**.
