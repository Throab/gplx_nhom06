-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 01, 2024 at 04:36 PM
-- Server version: 8.0.31
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gplx_nhom6`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `answerId` int NOT NULL,
  `answerContent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `isCorrect` int NOT NULL DEFAULT '0',
  `questionId` int NOT NULL,
  `answerExplain` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `flag` int NOT NULL DEFAULT '1',
  `isChoose` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`answerId`, `answerContent`, `isCorrect`, `questionId`, `answerExplain`, `flag`, `isChoose`) VALUES
(1, 'Gồm xe ô tô; máy kéo; xe mô tô hai bánh; xe mô tô ba bánh; xe gắn máy; xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.', 0, 1, NULL, 1, 0),
(2, 'Gồm xe ô tô; máy kéo; rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo; xe mô tô hai bánh; xe mô tô ba bánh, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự.', 1, 1, 'Phương tiện giao thông cơ giới gồm cả rơ moóc  hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo, xe máy điện. Đáp án 1 sai vì có xe máy chuyên dụng không là phương tiện giao thông đường bộ. Đáp án đúng: 2.', 1, 0),
(3, 'Được mang, vác tùy trường hợp cụ thể.', 0, 24, NULL, 1, 0),
(4, 'Không được mang, vác', 1, 24, 'Cấm người điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông mang, vác vật cồng kềnh. Đáp án 2 đúng.', 1, 0),
(5, 'Được mang, vác nhưng phải đảm bảo an toàn.', 0, 24, NULL, 1, 0),
(6, 'Được mang, vác tùy theo sức khỏe của bản thân.', 0, 24, NULL, 1, 0),
(7, 'Người điều khiển: Xe ô tô, xe mô tô, xe đạp, xe gắn máy.', 1, 21, 'Nghị định 100/2019, áp dụng 1/1/2020 thì người điều khiển phương tiện tham gia giao thông ô tô, xe máy, xe đạp mà trong hơi thở có nồng độ cồn đều bị nghiêm cấm. Đáp án 1 đúng.', 1, 0),
(8, 'Người ngồi phía sau người điều khiển xe cơ giới.', 0, 21, NULL, 1, 0),
(9, 'Người đi bộ.', 0, 21, NULL, 1, 0),
(10, 'Cả ý 1 và ý 2.', 0, 21, NULL, 1, 0),
(11, 'Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.', 0, 22, NULL, 1, 0),
(12, 'Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.', 1, 22, 'Làn đường là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có đủ bề rộng cho xe chạy an toàn. Câu 2 đúng.\r\nCâu 1 sai vi chia theo chiều dọc nhưng thiếu đủ bề rộng cho xe chạy an toàn.\r\nCâu 3 sai vì làn đường có thể sử dụng cho các loại phương tiện giao thông khác nhau chứ không chỉ riêng ô tô.', 1, 0),
(13, 'Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có đủ bề rộng cho xe ô tô chạy an toàn.', 0, 22, NULL, 1, 0),
(14, 'Được phép.', 0, 18, NULL, 1, 0),
(15, 'Tùy trường hợp.', 0, 18, NULL, 1, 0),
(16, 'Không được phép.', 1, 18, 'Cấm người điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy có những hành vi buông cả hai tay; sử dụng xa để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy. Đáp án 3 đúng.', 1, 0),
(17, 'Được phép.', 0, 30, NULL, 1, 0),
(18, 'Không được phép.', 1, 30, 'Không được phép, đáp án 2.', 1, 0),
(19, 'Tùy từng trường hợp.', 0, 30, NULL, 1, 0),
(20, 'Diễn ra trên đường phố không có người qua lại.', 0, 3, NULL, 1, 0),
(21, 'Được người dân ủng hộ.', 0, 3, NULL, 1, 0),
(22, 'Được cơ quan có thẩm quyền cấp phép.', 1, 3, 'Câu và 2 sai vì đều là hành vi đua xe trái phép. Hành vi đua xe trái phép là hành vi nghiêm cấm được quy định trong Luật giao thông đường bộ.\r\nĐáp án đúng là 3.', 1, 0),
(23, 'Được phép.', 0, 26, NULL, 1, 0),
(24, 'Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình.', 0, 26, NULL, 1, 0),
(25, 'Tùy trường hợp', 0, 26, NULL, 1, 0),
(26, 'Không được phép.', 1, 26, 'Cấm người điểu khiển xe mô tô hai bánh, ba bánh, xe gắn máy sử dụng xe để kéo, đẩy các xe khác, vật khác khi tham gia giao thông. Đáp án 4 đúng.', 1, 0),
(27, 'Được phép.', 0, 17, NULL, 1, 0),
(28, 'Được bám trong trường hợp phương tiện của mình bị hòng.', 0, 17, NULL, 1, 0),
(29, 'Được kéo, đẩy trong trường hợp phương tiện bị hỏng.', 0, 17, NULL, 1, 0),
(30, 'Không được phép.', 1, 17, 'Cấm người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông không được bám, kéo hoặc đẩy các phương tiện khác. Đáp án 4 dúng.', 1, 0),
(31, 'Được sử dụng.', 0, 10, NULL, 1, 0),
(32, 'Chỉ người ngồi sau được sử dụng.', 0, 10, NULL, 1, 0),
(33, 'Không được sử dụng.', 1, 10, 'Cấm người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông không được sử dụng ô tránh gây nguy hiểm cho bản thân và các phương tiện khác. Đáp án 3 đúng.', 1, 0),
(34, 'Được sử dụng nếu không có áo mưa.', 0, 10, NULL, 1, 0),
(35, 'Chỉ được kéo nếu đã nhìn thấy trạm xăng.', 0, 8, NULL, 1, 0),
(36, 'Chỉ được thực hiện trên đường vắng phương tiện cùng tham gia giao thông.', 0, 8, NULL, 1, 0),
(37, 'Không được phép', 1, 8, 'Cấm người điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy sử dụng xe để kéo, đẩy các xe khác, vật khác khi tham gia giao thông. Đáp án 3 đúng.', 1, 0),
(38, 'Bị nghiêm cấm tùy từng trường hợp.', 0, 14, NULL, 1, 0),
(39, 'Không bị nghiêm cấm.', 0, 14, NULL, 1, 0),
(40, 'Bị nghiêm cấm.', 1, 14, 'Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu là bị nghiêm cẩm. Đáp án 3 đúng', 1, 0),
(41, 'Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy.', 1, 9, 'Cấm người điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy có những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy. Đáp án 1 đúng.', 1, 0),
(42, 'Buông một tay; sử dụng xe để chở người hoặc hàng hóa; để chân chạm xuống đất khi khởi hành.', 0, 9, NULL, 1, 0),
(43, 'Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ.', 0, 9, NULL, 1, 0),
(44, 'Chở người ngồi sau dưới 16 tuổi.', 0, 9, NULL, 1, 0),
(45, 'Chỉ được phép nếu cả hai đội mũ bảo hiểm.', 0, 23, NULL, 1, 0),
(46, 'Không được phép', 1, 23, 'Cấm người ngồi trên xe mô tô kéo theo phương tiện khác. Đáp án 2 đúng.', 1, 0),
(47, 'Chỉ được phép thực hiện trên đường thật vắng.', 0, 23, NULL, 1, 0),
(48, 'Chỉ được phép khi người đi xe đạp đã mệt.', 0, 23, NULL, 1, 0),
(49, 'Chỉ bị nhắc nhở', 0, 15, NULL, 1, 0),
(50, 'Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.', 1, 15, 'Căn cứ nghị định 100/2019/NĐ-CP quy định về xử phạt khi tham gia giao thông có nồng độ cồng thì chọn đáp án 2.', 1, 0),
(51, 'Không bị xử lý hình sự.', 0, 15, NULL, 1, 0),
(52, 'Khi tham gia giao thông đường bộ.', 1, 4, 'Người ngồi trên xe mô tô, xe gắn máy bắt buộc phải đội mũ bảo hiểm và cài quai khi tham gia giao thông. Cứ ngồi lên xe là phải đội mũ bảo hiểm dù là đi gần. Có nhiều tai nạn thương tâm xảy ra do chủ quan không đội mũ bảo hiểm do đi gần, vừa ra khỏi nhà tai nạn luôn, các bạn cẩn thân nhé. Đáp án 1 đúng.', 1, 0),
(53, 'Chỉ khi đi trên đường chuyên dùng; đường cao tốc.', 0, 4, NULL, 1, 0),
(54, 'Khi tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ.', 0, 4, NULL, 1, 0),
(55, 'Bị nghiêm cấm', 1, 28, 'Cấm điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy.', 1, 0),
(56, 'Không bị nghiêm cấm.', 0, 28, NULL, 1, 0),
(57, 'Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.', 0, 28, NULL, 1, 0),
(58, 'Không được vận chuyển.', 1, 27, 'Cấm người điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông mang, vác vật cồng kềnh. Đáp án 1 đúng.', 1, 0),
(59, 'Chỉ đường vận chuyển khi đã chằng buộc cẩn thận.', 0, 27, NULL, 1, 0),
(60, 'Chỉ được vận chuyển vật cồng kệnh trên xe máy nếu khoảng cách về nhà ngắn hơn 2km.', 0, 27, NULL, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee101`
--

CREATE TABLE `employee101` (
  `user_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `questionId` int NOT NULL,
  `content` varchar(1000) COLLATE utf8mb4_general_ci NOT NULL,
  `image` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` int NOT NULL DEFAULT '0',
  `isChooseAnswer` tinyint(1) DEFAULT '0',
  `isImportant` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionId`, `content`, `image`, `type`, `isChooseAnswer`, `isImportant`) VALUES
(1, 'Khái niệm phương tiện cơ giới đường bộ được hiểu như thế nào là đúng?', 'NULL', 1, 0, 0),
(2, 'Khái niệm người điều khiển giao thông được hiểu như thế nào là đúng?', 'NULL', 1, 0, 0),
(3, 'Cuộc đua xe chỉ được thực hiện khi nào?', 'NULL', 1, 0, 1),
(4, 'Người ngồi trên xe mô tô hai bánh, xe gắn máy phải đội mũ bảo hiểm có cài quai đúng quy cách khi nào?', 'NULL', 1, 0, 1),
(5, 'Phương tiện tham gia giao thông đường bộ gồm những loại nào?', 'NULL', 1, 0, 0),
(6, 'Dải phân cách trên đường bộ gồm những loại nào?', 'NULL', 1, 0, 0),
(7, 'Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ hướng khác nhường đường khi đi qua nơi đường giao nhau, được cấm biển báo hiệu đường ưu tiên là loại đường gì?', 'NULL', 1, 0, 0),
(8, 'Hành vị sử dụng xe mô tô để kéo, đẩy mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không?', 'NULL', 1, 0, 1),
(9, 'Khi điều khiển mô tô hai bánh, ba bánh, xe gắn máy, những hành vi nào không được phép?', 'NULL', 1, 0, 0),
(10, 'Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được sử dụng ô hay không?', 'NULL', 1, 0, 0),
(11, 'Khái niệm phương tiện giao thông thô sơ đường bộ được hiểu như thế nào là đúng?', 'NULL', 1, 0, 0),
(12, 'Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?', 'NULL', 1, 0, 0),
(13, 'Trong các khái niệm dưới đây, khái niệm dường xe được hiểu như thế nào là đúng?', 'NULL', 1, 0, 0),
(14, 'Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành nhường, vượt ẩu có bị nghiêm cấm hay không?', 'NULL', 1, 0, 1),
(15, 'Sử dụng rượu, bia khi lái xe, xế bị phát hiện thì bị xử lý như thế nào', 'NULL', 1, 0, 1),
(16, 'Khái niệm đỗ xe được hiểu như thế nào là đúng?', 'NULL', 1, 0, 0),
(17, 'Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương tiện khác không?', 'NULL', 1, 0, 0),
(18, 'Khi điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép hay không?', 'NULL', 1, 0, 1),
(19, 'Người điểu khiển phương tiện tham gia giao thông đường bộ gồm những đối tượng nào dưới đây?', 'NULL', 1, 0, 0),
(20, 'Người tham gia giao thông đường bộ gồm những đối tượng nào?', 'NULL', 1, 0, 0),
(21, 'Theo luật phòng chống tác hại của rượu, bia, đối tượng nào dưới đây bị cấm sử dụng rượu, bia khi tham gia giao thông?', 'NULL', 1, 0, 1),
(22, 'Làn đường là gì?', 'NULL', 1, 0, 0),
(23, 'Khi đang lên dốc, người ngồi trên xe mô tô có được phép kéo theo người đang điều khiển xe đạp hay không?', 'NULL', 1, 0, 1),
(24, 'Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không?', 'NULL', 1, 0, 1),
(25, 'Trong các khái niệm dưới đây, \"dải phân cách\" được hiểu như thế nào là đúng?', 'NULL', 1, 0, 0),
(26, 'Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy phương tiện khác khi tham gia giao thông không?', 'NULL', 1, 0, 1),
(27, 'Hành vi vận chuyển đồ vật cồng kềnh bằng xe mô tô, xe gắn máy khi tham gia giao thông có được phép hay không?', 'NULL', 1, 0, 1),
(28, 'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?', 'NULL', 1, 0, 1),
(29, 'Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?', 'NULL', 1, 0, 0),
(30, 'Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không?', 'NULL', 1, 0, 1),
(31, 'Khái niệm về văn hóa giao thông được hiểu như thế nào là đúng?', 'NULL', 2, 0, 0),
(32, 'Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào?', 'NULL', 2, 0, 0),
(33, 'Trong các hành vi dưới đây, người lái xe mô tô có văn hóa giao thông phải ứng xử như thế nào', 'NULL', 2, 0, 0),
(34, 'Khi xảy ra tai nạn giao thông, có người bị thương nghiêm trọng, người lái xe và người có mặt tại hiện trường vụ tai nạn phải thực hiện các công việc gì?', 'NULL', 2, 0, 0),
(36, 'Trên dường xảy ra ùn tắc, những hành vi nào sau đây là thiếu văn hóa khi tham gia giao thông?', 'NULL', 2, 0, 0),
(37, 'Khi quay đầu xe, người lái xe cần phải quan sát và thực hiện các thao tác nào để đảm bảo an toàn giao thông?', 'NULL', 3, 0, 0),
(38, 'Khi tránh nhau trên đường hẹp, người lái xe cần phải chú ý những điểm nào để đảm bảo an toàn giao thông?', 'NULL', 3, 0, 0),
(39, 'Khi điều khiển xe trên đường vòng người lái xe cần phải làm gì để đảm bảo an toàn?', 'NULL', 3, 0, 0),
(40, 'Để đạt được hiệu quả phanh cao nhất, người lái xe mô tô phải sử dụng các kỹ năng như thế nào dưới đây?', 'NULL', 3, 0, 0),
(41, 'Những thói quen nào dưới đây khi điều khiển xe mô tô tay ga tham gia giao thông dễ gây tai nạn nguy hiểm?', 'NULL', 3, 0, 0),
(42, 'Khi điều khiển xe mô tô quay đầu người lái xe cần thực hiện như thế nào để đảm bảo an toàn?', 'NULL', 3, 0, 0),
(43, 'Tay ga trên xe mô tô hai bánh có tác dụng gì trong các trường hợp dưới đây?', 'NULL', 3, 0, 0),
(44, 'Gương chiếu hậu của xe mô tô hai bánh, có tác dụng gì trong các trường hợp dưới đây?', 'NULL', 3, 0, 0),
(45, 'Để đảm bảo an toàn khi tham gia giao thông, người lái xe mô tô hai bánh cần điều khiển tay ga như thế nào trong các trường hợp dưới đây?', 'NULL', 3, 0, 0),
(46, 'Kỹ thuật cơ bản để giữ thăng bằng khi điều khiển xe mô tô đi trên đường gồ ghề như thế nào trong các trường hợp dưới đây?', 'NULL', 3, 0, 0),
(47, 'Người ngồi trên xe mô tô hai bánh, xe gắn máy phải đội mũ bảo hiểm có cài quay đúng quy cách khi nào?', 'NULL', 3, 0, 1),
(48, 'Người điều khiển xe mô tô hai bánh, xe gắn máy có được đi xe dàn hàng ngang; đi xe vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ trợ thính) hay không?', 'NULL', 3, 0, 1),
(49, '1100', NULL, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_image`
--

CREATE TABLE `tbl_image` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_image`
--

INSERT INTO `tbl_image` (`id`, `name`) VALUES
(1, '16bc9b24-45f5-4cb2-ac6d-bf7b706bc594.jpeg'),
(2, '16bc9b24-45f5-4cb2-ac6d-bf7b706bc594.jpeg'),
(3, ''),
(4, ''),
(5, ''),
(6, ''),
(7, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`answerId`);

--
-- Indexes for table `employee101`
--
ALTER TABLE `employee101`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionId`);

--
-- Indexes for table `tbl_image`
--
ALTER TABLE `tbl_image`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee101`
--
ALTER TABLE `employee101`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `tbl_image`
--
ALTER TABLE `tbl_image`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
