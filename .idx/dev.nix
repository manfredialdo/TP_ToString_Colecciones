# To learn more about how to use Nix to configure your environment
# see: https://developers.google.com/idx/guides/customize-idx-env
{ pkgs, ... }: {
  # Which nixpkgs channel to use.
  channel = "stable-23.11"; # or "unstable"
  # Use https://search.nixos.org/packages to find packages
  packages = [
    pkgs.jdk21          # Java 21 de la cátedra
    pkgs.maven          # Gestor de dependencias
  ];
  # Sets environment variables in the workspace
  env = {};
  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "vscjava.vscode-java-pack"      # El motor esencial de Java
      "k--kato.intellij-idea-keybindings" # <--- ATADOS DE TECLADO DE INTELLIJ
      "mguenther.intellij-darcula"    # <--- TEMA VISUAL DARCULA (Opcional, para que se vea igual)
    ];
    workspace = {
      # Runs when a workspace is first created with this `dev.nix` file
      onCreate = {
        install = "mvn clean install -DskipTests";
      };
      # Runs when a workspace is (re)started
      onStart = {
        build = "mvn compile";
      };
    };
  };
}