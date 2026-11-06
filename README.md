# teamwork01 — Java Console Applications

日本語 / Tiếng Việt

## 概要 (Project overview)

このリポジトリは、Javaで作成したコンソールアプリケーションの学習・チーム制作プロジェクトです。

This repository contains three Java console applications created as a learning/team project.

### アプリケーション (Applications)

| Main class | 内容 (Description) |
|---|---|

| `teamwork01.testgame01` | 音声効果を使用する「Tokyo Survival」ゲーム (text-based survival game with audio effects) |

## 技術 (Technologies)

- Java 21
- Eclipse IDE project
- Java classpath library: `jl1.0.1.jar` (JLayer MP3 player)
- MP3 audio assets

## 必要な環境 (Requirements)

- JDK 21
- Eclipse IDE (任意 / optional)

## 実行方法 (How to run)

プロジェクトのルートディレクトリ (`teamwork01`) で実行してください。音声ファイルを相対パスで読み込むため、ルートディレクトリを作業ディレクトリにしてください。

Run these commands from the repository root. The game loads MP3 files using relative paths, so keep the working directory at the project root.

### macOS / Linux

```bash
mkdir -p bin
javac -encoding UTF-8 -cp jl1.0.1.jar -d bin src/teamwork01/*.java
java -cp "bin:jl1.0.1.jar" teamwork01.testgame01
```

To run the other applications, replace the final class name with `teamwork01.test2` or `teamwork01.teamapp1`.

### Windows (PowerShell / Command Prompt)

```powershell
mkdir bin
javac -encoding UTF-8 -cp jl1.0.1.jar -d bin src/teamwork01/*.java
java -cp "bin;jl1.0.1.jar" teamwork01.testgame01
```

## Eclipseで開く (Open in Eclipse)

1. GitHubからリポジトリをCloneします。
2. Eclipseで **File → Import → Existing Projects into Workspace** を選びます。
3. Cloneした `teamwork01` フォルダを選択します。
4. JDK 21をプロジェクトのJREとして設定します。
5. `src/teamwork01/testgame01.java` などを右クリックし、**Run As → Java Application** を選択します。
6. `testgame01` の音声が再生されない場合は、Run ConfigurationsのWorking Directoryをプロジェクトルートに設定してください。

## ディレクトリ構成 (Directory structure)

```text
teamwork01/
├── .classpath
├── .project
├── .gitignore
├── README.md
├── jl1.0.1.jar
├── src/
│   └── teamwork01/
│       ├── teamapp1.java
│       ├── test2.java
│       └── testgame01.java
└── *.mp3  (game sound assets)
```

MP3ファイルは現在Javaコードからファイル名で直接参照されているため、互換性を保つためにルートディレクトリに配置しています。

## 現在の制限・改善予定 (Limitations / future improvements)

- ユーザー情報はメモリ上にのみ保存され、アプリケーション終了後に消えます。
- パスワードはデモ用の簡易比較であり、安全な認証方式ではありません。実運用では使用しないでください。
- 入力値の検証、例外処理、JUnitテストを追加する予定です。
- MP3ファイルの利用条件・クレジットを確認し、必要な出典情報を追加する必要があります。
- クラス名をJavaの一般的な命名規則 (`TeamApp`, `ExpenseManager`, `TokyoSurvivalGame` など) に合わせて改善する予定です。

## 音声素材について (Audio assets)

このリポジトリには複数のMP3素材が含まれています。公開前に各素材の配布元、ライセンス、クレジット表記条件を確認してください。ファイル名だけでは利用許諾を確認できません。

## 作成者 (Author)

- Name: (ここに名前を記入 / Your name)
- GitHub: (GitHub profile URL)
