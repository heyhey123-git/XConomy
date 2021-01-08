package me.yic.xconomy.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class UpdateConfig {

    public static boolean update(FileConfiguration config, File cc) {
        boolean update = false;
        FileConfiguration ck = YamlConfiguration.loadConfiguration(cc);
        if (!ck.contains("MySQL.table-suffix")) {
            config.createSection("MySQL.table-suffix");
            if (ck.contains("MySQL.table_suffix")) {
                config.set("MySQL.table-suffix", config.getString("MySQL.table_suffix"));
            } else {
                config.set("MySQL.table-suffix", "");
            }
            update = true;
        }
        if (!ck.contains("Settings.non-player-account")) {
            config.createSection("Settings.non-player-account");
            config.set("Settings.non-player-account", false);
            update = true;
        }
        if (!ck.contains("Currency")) {
            config.createSection("Currency.singular-name");
            config.set("Currency.singular-name", "dollar");
            config.createSection("Currency.plural-name");
            config.set("Currency.plural-name", "dollars");
            config.createSection("Currency.integer-bal");
            if (ck.contains("Settings.integer")) {
                config.set("Currency.integer-bal", config.getBoolean("Settings.integer"));
            } else {
                config.set("Currency.integer-bal", false);
            }
            config.createSection("Currency.display-format");
            config.set("Currency.display-format", "%balance% %currencyname%");
            update = true;
        }
        if (!ck.contains("Currency.thousands-separator")) {
            config.createSection("Currency.thousands-separator");
            config.set("Currency.thousands-separator", ",");
            update = true;
        }
        if (!ck.contains("Pool-Settings.maximum-lifetime")) {
            config.createSection("Pool-Settings.maximum-pool-size");
            config.set("Pool-Settings.maximum-pool-size", 10);
            config.createSection("Pool-Settings.minimum-idle");
            config.set("Pool-Settings.minimum-idle", 10);
            config.createSection("Pool-Settings.maximum-lifetime");
            config.set("Pool-Settings.maximum-lifetime", 180000);
            update = true;
        }
        if (!ck.contains("Pool-Settings.idle-timeout")) {
            config.createSection("Pool-Settings.idle-timeout");
            config.set("Pool-Settings.idle-timeout", 60000);
            update = true;
        }
        if (!ck.contains("Settings.refresh-time")) {
            config.createSection("Settings.refresh-time");
            config.set("Settings.refresh-time", 300);
            update = true;
        }
        if (!ck.contains("Pool-Settings.usepool")) {
            config.createSection("Pool-Settings.usepool");
            if (ck.contains("MySQL.usepool")) {
                config.set("Pool-Settings.usepool", config.getBoolean("MySQL.usepool"));
            } else {
                config.set("Pool-Settings.usepool", true);
            }
            update = true;
        }
        if (!ck.contains("SQLite.path")) {
            config.createSection("SQLite.path");
            if (ck.contains("SQLite.address")) {
                config.set("SQLite.path", config.getString("SQLite.address"));
            } else {
                config.set("SQLite.path", "Default");
            }
            update = true;
        }
        if (!ck.contains("Settings.eco-command")) {
            config.createSection("Settings.eco-command");
            config.set("Settings.eco-command", true);
            config.createSection("Settings.transaction-record");
            config.set("Settings.transaction-record", true);
            config.createSection("Currency.max-number");
            config.set("Currency.max-number", "10000000000000000");
            config.createSection("MySQL.encoding");
            config.set("MySQL.encoding", "utf8");
            update = true;
        }
        if (!ck.contains("Settings.cache-correction")) {
            config.set("Settings.cache-correction", false);
            update = true;
        }
        if (!ck.contains("MySQL.timezone")) {
            config.createSection("MySQL.timezone");
            config.set("MySQL.timezone", "");
            update = true;
        }
        if (!ck.contains("Settings.disable-essentials")) {
            config.createSection("Settings.disable-essentials");
            config.set("Settings.disable-essentials", true);
            update = true;
        }
        if (!ck.contains("Settings.semi-online-mode")) {
            config.createSection("Settings.semi-online-mode");
            config.set("Settings.semi-online-mode", false);
            update = true;
        }
        return update;
    }
}
