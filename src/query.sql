delimiter $$

create database rss_game$$

delimiter $$

CREATE TABLE `always_slots` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `play_lines` text,
  `columns` int(11) DEFAULT NULL,
  `rows` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `bonusgames` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `game_id` varchar(36) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `total_clicks` int(2) DEFAULT NULL,
  `user_clicks` int(2) DEFAULT NULL,
  `source` varchar(2) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `prize_amount` varchar(1024) DEFAULT NULL,
  `multiplier` float DEFAULT NULL,
  `win_amount` float DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `bonusgameslogs` (
  `id` int(20) NOT NULL,
  `game_id` varchar(36) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `total_clicks` int(2) DEFAULT NULL,
  `user_clicks` int(2) DEFAULT NULL,
  `source` varchar(2) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `prize_amount` varchar(1024) DEFAULT NULL,
  `multiplier` float DEFAULT NULL,
  `win_amount` float DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `freespins` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `game_id` varchar(36) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `no_of_spins` int(2) DEFAULT NULL,
  `no_of_spins_left` int(2) DEFAULT NULL,
  `multiplier` float DEFAULT NULL,
  `source` varchar(2) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `denomination` float DEFAULT NULL,
  `noofcoins` int(2) DEFAULT NULL,
  `betlines` int(3) DEFAULT NULL,
  `spin_id` int(10) unsigned DEFAULT NULL,
  `win_amount` float DEFAULT NULL,
  `details` varchar(300) DEFAULT NULL,
  `reelset_id` varchar(36) DEFAULT NULL,
  `symbol_alias` varchar(36) DEFAULT NULL,
  `reel_set_index` int(1) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `freespinslogs` (
  `id` int(20) NOT NULL,
  `game_id` varchar(36) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `no_of_spins` int(2) DEFAULT NULL,
  `no_of_spins_left` int(2) DEFAULT NULL,
  `multiplier` float DEFAULT NULL,
  `source` varchar(2) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `denomination` float DEFAULT NULL,
  `noofcoins` int(2) DEFAULT NULL,
  `betlines` int(3) DEFAULT NULL,
  `spin_id` int(10) unsigned DEFAULT NULL,
  `win_amount` float DEFAULT NULL,
  `details` varchar(300) DEFAULT NULL,
  `reelset_id` varchar(36) DEFAULT NULL,
  `symbol_alias` varchar(36) DEFAULT NULL,
  `reel_set_index` int(1) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `gamblelogs` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `gambleid` int(20) NOT NULL,
  `gamespin_id` int(10) DEFAULT NULL,
  `account_id` int(10) DEFAULT NULL,
  `game_id` varchar(36) DEFAULT NULL,
  `bet_amount` float DEFAULT NULL,
  `won_amount` float DEFAULT NULL,
  `gamble_question` varchar(20) DEFAULT NULL,
  `gamble_answer` varchar(20) DEFAULT NULL,
  `gamble_rng_result` varchar(20) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `gambles` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `gamespin_id` int(10) DEFAULT NULL,
  `account_id` int(10) DEFAULT NULL,
  `game_id` varchar(36) DEFAULT NULL,
  `bet_amount` float DEFAULT NULL,
  `won_amount` float DEFAULT NULL,
  `gamble_question` varchar(20) DEFAULT NULL,
  `gamble_answer` varchar(20) DEFAULT NULL,
  `gamble_rng_result` varchar(20) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `game_configs` (
  `id` varchar(36) NOT NULL,
  `producer_uid` varchar(36) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `game_order` varchar(50) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `state_comments` text,
  `coins_max` int(11) DEFAULT NULL,
  `max_window` text,
  `play_window` text,
  `play_lines` text,
  `symbol_paytable` text,
  `symbol_paytable_common` text,
  `paylines_paytable` text,
  `pattern_paytable` text,
  `paytable_common_rules` text,
  `reel_set_config_array` text,
  `currencies_and_denominations` text,
  `fo_config` text,
  `fg_config` text,
  `gamble_enabled` tinyint(1) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  `revision` int(11) DEFAULT NULL,
  `logo_uploaded` tinyint(1) DEFAULT NULL,
  `pay_once` tinyint(1) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `gamelogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spin_id` int(10) DEFAULT NULL,
  `account_id` int(10) DEFAULT NULL,
  `game_id` varchar(36) DEFAULT NULL,
  `denomination` float DEFAULT NULL,
  `noofcoins` float DEFAULT NULL,
  `betlines` int(3) DEFAULT NULL,
  `trigger_gamble` tinyint(1) DEFAULT NULL,
  `reel_set_index` int(2) DEFAULT NULL,
  `old_wilds` text,
  `old_wilds_free` text,
  `outcome` varchar(1024) DEFAULT NULL,
  `element_matrix` varchar(1024) DEFAULT NULL,
  `winning_lines` varchar(1024) DEFAULT NULL,
  `bet_per_line` float DEFAULT NULL,
  `total_bet_amount` float DEFAULT NULL,
  `total_win_mount` float DEFAULT NULL,
  `line_win_mount` float DEFAULT NULL,
  `free_spin_win_mount` float DEFAULT NULL,
  `scatter_win_mount` float DEFAULT NULL,
  `spin_type` varchar(50) DEFAULT NULL,
  `amount_type` tinyint(1) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `lastgame_rss` (
  `log_id` int(10) NOT NULL,
  `account_id` int(10) NOT NULL DEFAULT '1',
  `config_id` int(5) NOT NULL DEFAULT '1',
  `denomination` int(4) NOT NULL DEFAULT '1',
  `noofcoins` int(2) NOT NULL DEFAULT '1',
  `betlines` int(2) NOT NULL DEFAULT '1',
  `outcome` varchar(50) NOT NULL DEFAULT '1',
  `element_matrix` varchar(255) NOT NULL DEFAULT '1',
  `winning_lines` varchar(255) NOT NULL DEFAULT '1',
  `amount_won` float(8,2) NOT NULL DEFAULT '1.00',
  `timestamp` datetime NOT NULL,
  `pjp_id` int(5) NOT NULL DEFAULT '1',
  `pjp_amount` float(12,5) NOT NULL DEFAULT '1.00000',
  `amount_type` int(1) NOT NULL DEFAULT '1',
  `spin_type` int(1) NOT NULL DEFAULT '1',
  `pjp_winstatus` int(1) NOT NULL DEFAULT '1',
  `pjp_winamount` float(12,5) NOT NULL DEFAULT '1.00000',
  `status` int(4) DEFAULT '1',
  `currency` varchar(16) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `lastgames` (
  `spin_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(10) DEFAULT NULL,
  `game_id` varchar(36) DEFAULT NULL,
  `denomination` float DEFAULT NULL,
  `noofcoins` float DEFAULT NULL,
  `betlines` int(3) DEFAULT NULL,
  `trigger_gamble` tinyint(1) DEFAULT NULL,
  `reel_set_index` int(2) DEFAULT NULL,
  `old_wilds` text,
  `old_wilds_free` text,
  `outcome` varchar(1024) DEFAULT NULL,
  `element_matrix` varchar(1024) DEFAULT NULL,
  `winning_lines` varchar(1024) DEFAULT NULL,
  `bet_per_line` float DEFAULT NULL,
  `total_bet_amount` float DEFAULT NULL,
  `total_win_mount` float DEFAULT NULL,
  `line_win_mount` float DEFAULT NULL,
  `free_spin_win_mount` float DEFAULT NULL,
  `scatter_win_mount` float DEFAULT NULL,
  `spin_type` varchar(50) DEFAULT NULL,
  `amount_type` tinyint(1) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`spin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `notifications` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `producer_id` varchar(255) DEFAULT NULL,
  `requester_producer_id` varchar(255) DEFAULT NULL,
  `game_name` text,
  `game_id` varchar(36) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `state_comments` text,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `producer_paylines` (
  `id` varchar(36) NOT NULL,
  `producer_id` varchar(255) DEFAULT NULL,
  `pay_lines` text,
  `name` varchar(255) DEFAULT NULL,
  `columns` int(11) DEFAULT NULL,
  `rows` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `producers` (
  `id` varchar(255) NOT NULL,
  `forgot_password_code` text,
  `uid` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `password` char(64) DEFAULT NULL,
  `associated_game_configs` text,
  `custom_data` text,
  `session_info` text,
  `revision` int(11) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `producers_email_unique` (`email`),
  UNIQUE KEY `producers_mobile_unique` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `slots2_rss` (
  `log_id` int(10) NOT NULL,
  `account_id` int(10) NOT NULL DEFAULT '1',
  `config_id` int(5) NOT NULL DEFAULT '1',
  `denomination` int(4) NOT NULL DEFAULT '1',
  `noofcoins` int(2) NOT NULL DEFAULT '1',
  `betlines` int(2) NOT NULL DEFAULT '1',
  `outcome` varchar(50) NOT NULL DEFAULT '1',
  `element_matrix` varchar(255) NOT NULL DEFAULT '1',
  `winning_lines` varchar(255) NOT NULL DEFAULT '1',
  `amount_won` float(8,2) NOT NULL DEFAULT '1.00',
  `timestamp` datetime NOT NULL,
  `pjp_id` int(5) NOT NULL DEFAULT '1',
  `pjp_amount` float(12,5) NOT NULL DEFAULT '1.00000',
  `amount_type` int(1) NOT NULL DEFAULT '1',
  `spin_type` int(1) NOT NULL DEFAULT '1',
  `pjp_winstatus` int(1) NOT NULL DEFAULT '1',
  `pjp_winamount` float(12,5) NOT NULL DEFAULT '1.00000',
  `status` int(4) DEFAULT '1',
  `currency` varchar(16) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `suggested_paylines` (
  `id` varchar(36) NOT NULL,
  `pay_lines` text,
  `name` varchar(255) DEFAULT NULL,
  `columns` int(11) DEFAULT NULL,
  `rows` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `transactions_log_rss` (
  `serial_id` int(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) NOT NULL DEFAULT '1',
  `game_type` varchar(2) NOT NULL DEFAULT '1',
  `game_id` int(20) DEFAULT '1',
  `date_time` datetime NOT NULL,
  `amount` float(12,2) NOT NULL DEFAULT '1.00',
  `stream_id` varchar(20) NOT NULL DEFAULT '1',
  `trans_type` int(4) NOT NULL DEFAULT '1',
  `amount_type` int(1) NOT NULL DEFAULT '1',
  `note` text,
  `parent_id` int(10) NOT NULL DEFAULT '1',
  `track_id` varchar(30) DEFAULT '1',
  `system_id` int(3) NOT NULL DEFAULT '1',
  `misc_id` int(3) NOT NULL DEFAULT '1',
  `currency` varchar(3) NOT NULL DEFAULT 'GBP',
  `processed` int(1) NOT NULL DEFAULT '1',
  `error` int(1) NOT NULL DEFAULT '1',
  `real_sub` float(12,2) NOT NULL DEFAULT '1.00',
  `bonus_sub` float(12,2) NOT NULL DEFAULT '1.00',
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`serial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


;