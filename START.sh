#!/bin/bash
echo "Podaj sciezke do katalogu lib JavaFX"
read path
java --module-path $path --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar Clicker_v2.jar
