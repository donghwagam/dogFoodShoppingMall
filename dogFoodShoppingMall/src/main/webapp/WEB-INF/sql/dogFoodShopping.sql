-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.2.43-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- shopping 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shopping`;

-- 테이블 shopping.address 구조 내보내기
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `zip_code` char(5) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '우편번호',
  `province` varchar(30) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '시도',
  `city` varchar(30) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '시군구',
  `town` varchar(30) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '읍면',
  `street` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '도로명',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6337150 DEFAULT CHARSET=utf8mb4;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.allergy 구조 내보내기
CREATE TABLE IF NOT EXISTS `allergy` (
  `allergy_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`allergy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.basket 구조 내보내기
CREATE TABLE IF NOT EXISTS `basket` (
  `product_id` int(11) NOT NULL,
  `member_id` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`product_id`,`member_id`),
  KEY `FK_basket_member_id` (`member_id`),
  CONSTRAINT `FK_basket_member_id` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_basket_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.brand 구조 내보내기
CREATE TABLE IF NOT EXISTS `brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.category 구조 내보내기
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.component 구조 내보내기
CREATE TABLE IF NOT EXISTS `component` (
  `component_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`component_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.dog 구조 내보내기
CREATE TABLE IF NOT EXISTS `dog` (
  `dog_id` int(11) NOT NULL AUTO_INCREMENT,
  `spiece` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`dog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` varchar(100) NOT NULL,
  `member_pw` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birth` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` enum('남','여') NOT NULL,
  `level` enum('0','1') NOT NULL DEFAULT '1',
  `active` enum('0','1') NOT NULL DEFAULT '1',
  `address_id` int(11) NOT NULL,
  `detail_addr` varchar(100) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `pw_update_date` datetime NOT NULL,
  PRIMARY KEY (`member_id`),
  KEY `FK_member_address` (`address_id`),
  CONSTRAINT `FK_member_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.member_dog 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_dog` (
  `member_dog_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(100) NOT NULL,
  `dog_id` int(11) NOT NULL,
  `dog_name` varchar(50) NOT NULL,
  `birth` varchar(50) NOT NULL,
  `weight` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`member_dog_id`),
  KEY `FK__dog` (`dog_id`),
  KEY `FK_member` (`member_id`),
  CONSTRAINT `FK__dog` FOREIGN KEY (`dog_id`) REFERENCES `dog` (`dog_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.member_dog_allergy 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_dog_allergy` (
  `member_dog_id` int(11) NOT NULL,
  `allergy_id` int(11) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`member_dog_id`,`allergy_id`),
  KEY `FK_member_dog_allergy` (`allergy_id`),
  CONSTRAINT `FK_member_dog` FOREIGN KEY (`member_dog_id`) REFERENCES `member_dog` (`member_dog_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_member_dog_allergy` FOREIGN KEY (`allergy_id`) REFERENCES `allergy` (`allergy_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.member_pw_record 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_pw_record` (
  `member_id` varchar(50) NOT NULL,
  `pw_record` varchar(50) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`member_id`,`pw_record`),
  CONSTRAINT `FK_member_pw_record_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(100) NOT NULL,
  `notice_content` text NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `gram` double NOT NULL,
  `rate` enum('로가닉','오가닉','홀리스틱','슈퍼프리미엄','프리미엄','일반') NOT NULL,
  `feed_size` enum('소','중','대') NOT NULL,
  `origin` varchar(50) NOT NULL,
  `info` text NOT NULL,
  `stock` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK__brand` (`brand_id`),
  CONSTRAINT `FK__brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.product_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_category` (
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`product_id`,`category_id`),
  KEY `FK__product_category_category` (`category_id`),
  CONSTRAINT `FK__product_category_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__product_cateogory_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.product_component 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_component` (
  `product_id` int(11) NOT NULL,
  `component_id` int(11) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`product_id`,`component_id`) USING BTREE,
  KEY `FK_product_component_component` (`component_id`) USING BTREE,
  CONSTRAINT `FK_component` FOREIGN KEY (`component_id`) REFERENCES `component` (`component_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_product_component_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.product_photo 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_photo` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `original_name` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `type` varchar(50) NOT NULL,
  `product_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `FK_photo_product` (`product_id`),
  CONSTRAINT `FK_photo_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.purchase 구조 내보내기
CREATE TABLE IF NOT EXISTS `purchase` (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(100) NOT NULL,
  `status` enum('결제전','결제완료','배송완료') NOT NULL DEFAULT '결제전',
  `payment` varchar(50) NOT NULL,
  `total_price` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`purchase_id`),
  KEY `FK_purchase_member` (`member_id`),
  CONSTRAINT `FK_purchase_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.purchase_address 구조 내보내기
CREATE TABLE IF NOT EXISTS `purchase_address` (
  `purchase_id` int(11) NOT NULL,
  `purchase_name` varchar(50) NOT NULL,
  `purchase_phone` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`purchase_id`),
  CONSTRAINT `FK_purchase_address_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.purchase_list 구조 내보내기
CREATE TABLE IF NOT EXISTS `purchase_list` (
  `purchase_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`purchase_id`,`product_id`),
  KEY `FK__product` (`product_id`),
  CONSTRAINT `FK__product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.qna 구조 내보내기
CREATE TABLE IF NOT EXISTS `qna` (
  `qna_id` int(11) NOT NULL AUTO_INCREMENT,
  `qna_kind` enum('질문','답변') NOT NULL,
  `memo` text NOT NULL,
  `member_id` varchar(100) NOT NULL,
  `product_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`qna_id`,`qna_kind`),
  KEY `FK_qna_product` (`product_id`),
  KEY `FK_qna_member` (`member_id`),
  CONSTRAINT `FK_qna_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_qna_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.review 구조 내보내기
CREATE TABLE IF NOT EXISTS `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `review_content` text NOT NULL,
  `star` double NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK_review_purchase` (`purchase_id`),
  KEY `FK_review_product` (`product_id`),
  CONSTRAINT `FK_review_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_review_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shopping.review_photo 구조 내보내기
CREATE TABLE IF NOT EXISTS `review_photo` (
  `review_photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `original_name` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `type` varchar(50) NOT NULL,
  `volume` int(11) NOT NULL,
  `review_id` int(11) NOT NULL,
  PRIMARY KEY (`review_photo_id`) USING BTREE,
  KEY `FK_review_photo_review` (`review_id`),
  CONSTRAINT `FK_review_photo_review` FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
