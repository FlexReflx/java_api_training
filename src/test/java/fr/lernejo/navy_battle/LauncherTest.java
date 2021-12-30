package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LauncherTest {
    @Test
    public void port_trop_grand() {
        Assertions.assertThrows( Exception.class, () -> Launcher.main(new String[] {"11235"}));
    }

    @Test
    public void mauvais_type_arg() {
        Assertions.assertThrows( Exception.class, () -> Launcher.main(new String[] {"port_sous_forme_de string"}));
    }

    @Test
    public void arg_manquant() {
        Assertions.assertThrows( Exception.class, () -> Launcher.main(new String[] {}));
    }
}
