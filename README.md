# IterableProviderパターン
[Iterableを直接実装しない]で紹介したIterableProviderパターンのサンプルコード。

## 動作確認方法
本プログラムではGitHub Packagesに公開されているライブラリを利用しています。GitHub Packagesで公開されたパッケージの利用にはGitHubの個人アクセストークンが必要になります。  
また本プロジェクトはGradleプロジェクトです。Gradleプロジェクトを実行するためにはラッパータスクを実行する必要があります。  
以下に動作確認の手順を示します。  

1. [GitHub Packagesのドキュメント]に従ってread:packagesスコープの設定された個人アクセストークンを用意してください。
1. [Gradleのドキュメント]に従って以下のGradlePropertyを設定してください。
    1. github.username 個人アクセストークンのユーザ名
    1. github.password 個人アクセストークンのトークン文字列
1. 本リポジトリをクローンし、gradlewを実行した上でrunタスクを実行してください。

## 連絡先
何か問題がありましたら[@RayStark77]か[Iterableを直接実装しない]のコメント欄にお知らせ下さい。

[Iterableを直接実装しない]: https://raystark.hatenablog.com/
[GitHub Packagesのドキュメント]: https://docs.github.com/ja/free-pro-team@latest/github/authenticating-to-github/creating-a-personal-access-token
[Gradleのドキュメント]: https://docs.gradle.org/6.7.1/userguide/build_environment.html#sec:gradle_configuration_properties
[@RayStark77]: https://twitter.com/RayStark77