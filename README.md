# PurseCheck

PurseCheck is a professional Kotlin Multiplatform personal-finance frontend reference application built with Compose Multiplatform.

The project demonstrates how one shared application can provide adaptive, accessible and platform-appropriate experiences across:

- Android
- iOS
- Desktop/JVM
- Web/Wasm
- Web/JS

PurseCheck uses deterministic demonstration data and does not require a backend.

## Project Goals

The project focuses on:

- adaptive layouts;
- responsive navigation;
- shared Compose UI;
- light, dark and system themes;
- reusable design-system components;
- accessibility;
- predictable state management;
- testable architecture;
- custom financial visualisation;
- professional Kotlin Multiplatform development practices.

## Architecture

PurseCheck is designed as one shared application with multiple platform hosts.

Shared UI and application behaviour live primarily in:

`shared/src/commonMain`

Platform-specific source sets are used only where genuine platform integration is required.

Detailed project decisions are documented in:

- `PROJECT_CHARTER.md`
- `docs/ENGINEERING_STANDARDS.md`

## Running the Applications

### Android

```bash
./gradlew :androidApp:assembleDebug
```

### Desktop

Standard run:

```bash
./gradlew :desktopApp:run
```

Hot reload:

```bash
./gradlew :desktopApp:hotRun --auto
```

### Web — Wasm

```bash
./gradlew :webApp:wasmJsBrowserDevelopmentRun
```

### Web — JavaScript

```bash
./gradlew :webApp:jsBrowserDevelopmentRun
```

### iOS

Open the `iosApp` project in Xcode and run the iOS application from there.

## Testing

Shared tests are placed in the appropriate Kotlin Multiplatform test source sets.

The project favours behavioural tests over placeholder assertions.

Testing expands alongside application functionality and includes common logic, state behaviour, components, adaptive layouts and platform-specific behaviour where appropriate.

## Development Process

Development is divided into small numbered increments.

Each increment must reach a known working state before being marked **GREEN**.

A GREEN implementation is reviewed and tested before it becomes the basis of the corresponding tutorial implementation.

## Roadmap

- F0 — Project Foundation
- F1 — Brand & Design Tokens
- F2 — Theme Engine
- F3 — Adaptive Layout Foundation
- F4 — Adaptive Application Shell
- F5 — Dashboard
- F6 — Financial Chart
- F7 — Transactions
- F8 — Budgets
- F9 — Analytics
- F10 — Goals
- F11 — Settings & Personalisation
- F12 — Accessibility Hardening
- F13 — Responsive Hardening
- F14 — Testing & Production Polish

## Scope

PurseCheck is a frontend reference application.

It does not provide:

- real banking integration;
- payments;
- financial transactions;
- production authentication;
- cloud synchronisation;
- financial advice.

All displayed financial information is demonstration data.