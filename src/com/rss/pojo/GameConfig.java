package com.rss.pojo;

import java.util.ArrayList;
import java.util.Map;

public class GameConfig {
    private ArrayList<SymbolObj> symbol_paytable;
    private PlayLines play_lines;
    private PlayWindow play_window;
    private ArrayList<ReelSet> reel_set_config_array;
    private ArrayList<LinePatternObj> paylines_paytable;
    private SymbolPayTable symbol_paytable_common;
    private Integer[] fo_config;
    private String game_order;
    private boolean gamble_enabled;
    private boolean pay_once;
    private PlayLines alwaysSlotsPayLines;

    private Map<String,Integer> fg_config;

    public GameConfig() {
    }

    public PlayLines getAlwaysSlotsPayLines() {
        return alwaysSlotsPayLines;
    }

    public void setAlwaysSlotsPayLines(PlayLines alwaysSlotsPayLines) {
        this.alwaysSlotsPayLines = alwaysSlotsPayLines;
    }

    public Map<String, Integer> getFg_config() {
        return fg_config;
    }

    public void setFg_config(Map<String, Integer> fg_config) {
        this.fg_config = fg_config;
    }

    public boolean isGamble_enabled() {
        return gamble_enabled;
    }

    public void setGamble_enabled(boolean gamble_enabled) {
        this.gamble_enabled = gamble_enabled;
    }

    public boolean isPay_once() {
        return pay_once;
    }

    public void setPay_once(boolean pay_once) {
        this.pay_once = pay_once;
    }

    public String getGame_order() {
        return game_order;
    }

    public void setGame_order(String game_order) {
        this.game_order = game_order;
    }

    public Integer[] getFo_config() {
        return fo_config;
    }

    public void setFo_config(Integer[] fo_config) {
        this.fo_config = fo_config;
    }

    public SymbolPayTable getSymbol_paytable_common() {
        return symbol_paytable_common;
    }

    public void setSymbol_paytable_common(SymbolPayTable symbol_paytable_common) {
        this.symbol_paytable_common = symbol_paytable_common;
    }


    public ArrayList<SymbolObj> getSymbol_paytable() {
        return symbol_paytable;
    }

    public void setSymbol_paytable(ArrayList<SymbolObj> symbol_paytable) {
        this.symbol_paytable = symbol_paytable;
    }

    public ArrayList<ReelSet> getReel_set_config_array() {
        return reel_set_config_array;
    }

    public void setReel_set_config_array(ArrayList<ReelSet> reel_set_config_array) {
        this.reel_set_config_array = reel_set_config_array;
    }

    public PlayLines getPlay_lines() {
        return play_lines;
    }

    public void setPlay_lines(PlayLines play_lines) {
        this.play_lines = play_lines;
    }

    public ArrayList<LinePatternObj> getPaylines_paytable() {
        return paylines_paytable;
    }

    public void setPaylines_paytable(ArrayList<LinePatternObj> paylines_paytable) {
        this.paylines_paytable = paylines_paytable;
    }

    public PlayWindow getPlay_window() {
        return play_window;
    }

    public void setPlay_window(PlayWindow play_window) {
        this.play_window = play_window;
    }
}
