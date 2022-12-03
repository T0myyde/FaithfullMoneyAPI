package ch.tom.faithful.moneyapi.api;

import ch.tom.faithful.moneyapi.MoneyApi;
import org.bukkit.OfflinePlayer;

public class FaithfullMoneyAPI {

    public double getPlayerBalance(OfflinePlayer player) {
        return MoneyApi.getEcon().getBalance(player);
    }

    public boolean checkPlayerMoney(OfflinePlayer player, double amount) {
        return MoneyApi.getEcon().has(player, amount);
    }

    public boolean removePlayerMoney(OfflinePlayer player, double amount) {
        return MoneyApi.getEcon().withdrawPlayer(player, amount).transactionSuccess();
    }

    public boolean addPlayerMoney(OfflinePlayer player, double amount) {
        return MoneyApi.getEcon().depositPlayer(player, amount).transactionSuccess();
    }
}
