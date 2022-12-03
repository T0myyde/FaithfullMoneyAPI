package ch.tom.faithful.moneyapi;

import ch.tom.faithful.moneyapi.api.FaithfullMoneyAPI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoneyApi extends JavaPlugin {

    private static MoneyApi instance;

    private static Economy econ = null;
    public FaithfullMoneyAPI faithfullMoneyAPI;

    @Override
    public void onEnable() {
        instance = this;
        setupEconomy();
        faithfullMoneyAPI = new FaithfullMoneyAPI();
    }

    @Override
    public void onDisable() {
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }


    public static MoneyApi getInstance() {
        return instance;
    }

    public static Economy getEcon() {
        return econ;
    }

    public FaithfullMoneyAPI getFaithfullMoneyAPI() {
        return faithfullMoneyAPI;
    }
}
