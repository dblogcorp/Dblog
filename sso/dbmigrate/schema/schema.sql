SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `status` tinyint(1) NOT NULL COMMENT '1 --未激活, 2 -- 已激活, 3 --已锁定',
  `email` varchar(64) NOT NULL COMMENT '邮件地址',
  `email_validation` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '1 --未验证, 2 --已验证',
  `user_name` varchar(32) NOT NULL COMMENT '用户名, 不可改变, 只允许包含字符和数字以及连字号, 不允许以连字号开头或结尾',
  `name` varchar(32) DEFAULT NULL COMMENT '昵称, 可以改变',
  `password` char(128) NOT NULL COMMENT '用户密码',
  `gravatar` varchar(512) NOT NULL COMMENT '用户头像',
  `sex` tinyint(1) unsigned DEFAULT NULL COMMENT '用户性别, 1 --男, 2 --女',
  `location` varchar(32) DEFAULT NULL COMMENT '所在地区',
  `company` varchar(64) DEFAULT NULL COMMENT '所在公司',
  `website` varchar(64) DEFAULT NULL COMMENT '个人网站',
  `github_add` varchar(128) DEFAULT NULL COMMENT 'GitHub 地址',
  `sign` varchar(512) DEFAULT NULL COMMENT '用户签名',
  `coding_add` varchar(64) DEFAULT NULL COMMENT 'Coding.NET 地址',
  `twitter_add` varchar(64) DEFAULT NULL COMMENT 'Twitter 地址',
  `weibo_add` varchar(64) DEFAULT NULL COMMENT '微博地址',
  `zhihu_add` varchar(64) DEFAULT NULL COMMENT '知乎地址',
  `intro` varchar(128) DEFAULT NULL COMMENT '用户简介',
  `user_agent` varchar(128) DEFAULT NULL COMMENT '注册 UA',
  `register_ip` varchar(20) DEFAULT NULL COMMENT '注册 IP',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '最后更新时间',
  `deleted_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_name` (`user_name`),
  KEY `idx_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='账户表';

DROP TABLE IF EXISTS `account_relationships`;
CREATE TABLE `account_relationships` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account_id` int(10) NOT NULL COMMENT '用户 ID',
  `type` tinyint(1) NOT NULL COMMENT '用户关系类型, 1 --关注, 2 --拉黑',
  `relation_account_id` int(10) NOT NULL COMMENT '用户对应的关系用户 ID',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '最后更新时间',
  `deleted_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户关系表';

DROP TABLE IF EXISTS `notifications`;
CREATE TABLE `notifications` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account_id` int(10) NOT NULL COMMENT '用户 ID',
  `type` tinyint(1) NOT NULL COMMENT '类型, 1 --关注通知, 2 --评论通知/@通知, 3 --点赞通知',
  `status` tinyint(1) NOT NULL COMMENT '状态, 1 --未读, 2 --已读',
  `notification_account_id` int(10) DEFAULT NULL COMMENT '通知动作发起人 ID',
  `original_topic` varchar(128) DEFAULT NULL COMMENT '主题标题',
  `original_address` varchar(64) DEFAULT NULL COMMENT '主题地址',
  `content` text DEFAULT NULL COMMENT '评论/@/点赞 内容',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '最后更新时间',
  `deleted_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_id` (`account_id`),
  KEY `idx_account_type` (`account_id`, `type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='通知表';

DROP TABLE IF EXISTS `private_letters`;
CREATE TABLE `private_letters` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account_id` int(10) NOT NULL COMMENT '用户 ID',
  `letter_by` int(10) NOT NULL COMMENT '私信发起人 ID',
  `content` text NOT NULL COMMENT '私信内容',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '最后更新时间',
  `deleted_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_id` (`account_id`),
  KEY `idx_letter_by` (`letter_by`),
  KEY `idx_account_and_by` (`account_id`, `letter_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='私信表';

-- 暂时没想好
DROP TABLE IF EXISTS `notification_letter_settings`;
CREATE TABLE `notification_letter_settings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `letter_passed` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1 --允许所有人, 2 --仅允许我关注的人',
  `letter_email` tinyint(1) DEFAULT NULL COMMENT '1 --有私信邮件通知我',
  `notification_focus` tinyint(1) DEFAULT NULL COMMENT '',
  `notification_thumb` tinyint(1) DEFAULT NULL COMMENT '',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '最后更新时间',
  `deleted_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='通知/私信设置表';