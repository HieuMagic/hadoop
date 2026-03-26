# **1. Thông tin chung**

* **Thời gian:** Các bài thực hành và lý thuyết liên quan đến Spark sẽ kéo dài trong 2 tuần.

---

## **2. Giới thiệu Lab 1 - Cài đặt Hadoop & HDFS**

* **Mục đích của Big Data & HDFS:** Phân tán dữ liệu (distribute storage) để xử lý song song và nhân bản (replicate) dữ liệu nhằm tránh rủi ro mất mát.
* **Khái niệm cơ bản (HDFS):** File dữ liệu sẽ được chia nhỏ thành các Block.
  * **NameNode:** Nơi lưu trữ Metadata (ví dụ: giống như danh mục tra cứu vị trí sách trong thư viện).
  * **DataNode:** Nơi lưu trữ dữ liệu thực tế (các block dữ liệu, ví dụ: vị trí chính xác của cuốn sách ở kệ 2, tầng 3).

---

## **3. Yêu cầu Lab 1 - Phần Cài đặt**

Phần này yêu cầu thực hành cá nhân dù làm theo nhóm. Các bạn có thể sử dụng Windows, Mac, hoặc Linux và chọn link hướng dẫn phù hợp để cài đặt.

* **Single-Node Cluster:** * Tìm hiểu về NameNode, DataNode và YARN.
  * Cài đặt Hadoop chạy trên máy cá nhân (Local). Mọi xử lý chỉ diễn ra trên 1 máy tính.
* **Multi-Node Cluster (Dành cho nhóm):** * Ví dụ nhóm 5 người sẽ cần thiết lập 1 máy chủ (Master) và 4 máy con (Slave) để Master điều phối xử lý.
* **File `.jar` của Thầy Đăng:** * Sau khi tạo xong thư mục trên HDFS, mỗi sinh viên phải chạy file `.jar` của thầy Đăng cung cấp.
  * Lệnh này sẽ trả về một file `.txt` chứa địa chỉ IP của máy.
  * **Lưu ý cực kỳ quan trọng:** File output `.txt` phải mang IP khác nhau cho từng người. Nếu IP trùng nhau giữa các thành viên, bài đó sẽ bị  **0 điểm** .
* **Báo cáo lỗi (Detail Report):** Quá trình cài đặt chắc chắn sẽ phát sinh lỗi tùy thuộc vào hệ điều hành. Các bạn cần ghi nhận lại chi tiết các lệnh đã chạy, lỗi gặp phải và cách giải quyết (Resolve) của  **từng cá nhân** .

---

## **4. Yêu cầu Lab 1 - Phần Bài tập (WordCount)**

Kiểm tra xem hệ thống dữ liệu phân tán có hoạt động đúng hay không.

* **Yêu cầu:** Cho một file `.txt` chứa danh sách các từ. Các bạn cần lọc và đếm số lần xuất hiện của các từ có chữ cái bắt đầu nằm trong 8 chữ cái của cụm từ khóa (ví dụ:  **FIT HCMUS** ).
* **Cơ chế MapReduce:**
  * **Map:** Đọc từng dòng, tách từ và lấy chữ cái đầu tiên làm `Key`, gán `Value` là `1` (VD: `F: 1`).
  * **Shuffle & Sort:** Hệ thống tự động gom nhóm các `Key` giống nhau (VD: gom tất cả các key `F` lại).
  * **Reduce:** Tính tổng `Value` của các `Key` giống nhau để ra kết quả cuối cùng (VD: `F: 2`).
* **Ngôn ngữ lập trình:** Hỗ trợ Python, Java và Scala.
  * **Lưu ý:** Nếu dùng Python với thư viện `regex`, chương trình sẽ chạy không đúng cơ chế MapReduce. Do đó, để đạt điểm tối đa ở phần này, **bắt buộc phải sử dụng Scala** (không dùng regex, tự viết code lấy chữ cái đầu tiên).

---

## **5. Quy định Nộp bài & Báo cáo**

* **Đóng gói file:** Cả nhóm nén lại thành một file `.zip` duy nhất.
* **Cấu trúc thư mục:** Bên trong file `.zip`, tạo các thư mục con đặt tên theo Mã số sinh viên (MSSV) của từng người.
* **Nội dung nộp:**
  * **Thư mục cá nhân:** Chứa file Source code, file kết quả WordCount và file `.txt` (IP) sinh ra từ tool của thầy Đăng.
  * **File Báo cáo (Report):** Gộp chung 1 file cho cả nhóm cho gọn. Tuy nhiên, nội dung bên trong file báo cáo phải chia rõ phần cài đặt, lỗi và cách khắc phục theo từng MSSV. Riêng phần báo cáo bài WordCount thì chỉ cần viết chung 1 lần cho cả nhóm.

---

## 6. Original

 Rồi thì hôm nay mình nói về Lab 1. Giới thiệu thì các bạn đã học, nghe
qua về Hadoop với lại HDFS rồi. Thì không biết là các bạn có nghe qua về
 hai cái khái niệm — đầu tiên là về HDFS trước đi — thì các bạn hiểu
HDFS như thế nào? Có nghĩa là cái mục đích của môn này và của HDFS là để
 làm gì, thì bạn nào trả lời được cho mình biết không?

 Rồi, ok, cảm ơn bạn Quân. Thì đại khái là các bạn học về mục đích của
big data là nó sẽ làm với dạng dữ liệu phân tán — nó sẽ distribute cái
storage ra, đúng không? Rồi để nó song song, đó là nó xử lý cái vấn đề
song song và replicate data để không bị vấn đề lỗi.

 Rồi thì không biết là các bạn đã nghe qua khái niệm về NameNode với
DataNode chưa? Nó sẽ là hai cái này: NameNode và DataNode, hả?

 Rồi thì sẵn ha. Bây giờ mấy bạn hình dung nè. Ờ, khi các bạn — bây giờ
bài Lab 1 mình nói sơ qua ha. Đầu tiên, bài Lab 1 thì chủ yếu các bạn sẽ
 có hai phần đây. Ờ, không biết mấy bạn xem qua bài chưa — thì các bạn
sẽ có hai phần. Phần đầu tiên là phần cài đặt. Phần cài đặt thì các bạn
sẽ tìm hiểu về các khái niệm là NameNode, DataNode và YARN. Sau đó là
các bạn sẽ có một bài tập nhỏ. Chú ý là cái phần bài tập này, nặng phần
cài đặt là chính.

 Thì bây giờ nói sơ qua về NameNode, về DataNode đi. Thì các bạn hình
dung — NameNode — bây giờ các bạn hình dung ha. Ví dụ như là do nó lưu
dữ liệu phân tán thì nó sẽ có khái niệm gọi là block, ha. Rồi thì bạn
nói là... NameNode nó sẽ là cái nơi lưu trữ thông tin về các data — có
nghĩa là một cái NameNode này nó sẽ chứa thông tin về các data. Còn cái
DataNode là cái gì? Ví dụ bây giờ các bạn tưởng tượng ha — bây giờ các
bạn là một người quản lý thư viện đi. Bây giờ sách thì các bạn có rất là
 nhiều. Thì cái DataNode này nó sẽ như là một cái chỗ để các bạn lưu vị
trí từng cuốn sách. Ví dụ mình có một cái DataNode — ví dụ như là cuốn
sách ở kệ 2, tầng 3. Ví dụ vậy. Thì cái này nó là cái DataNode. Thì
NameNode nó sẽ lưu cái gì? NameNode nó sẽ lưu cái metadata. Thì cái này
khi mà các bạn làm Lab, các bạn sẽ tìm hiểu kỹ hơn — là các bạn sẽ hiểu
là một cái file nó chia thành các block, thì mỗi block này để nó chia
nhỏ cái bộ nhớ, các bạn hình dung ha.

 Rồi thì trong bài Lab này nó sẽ — các bạn sẽ làm gì? Đầu tiên ha, các
bạn sẽ tìm hiểu cho mình hai cái link sau. Các bạn sẽ lên setup — nó sẽ
là setup single-node cluster. Thì Lab này, mặc dù là các bạn làm theo
nhóm, nộp bài theo nhóm, nhưng mà từng cá nhân của các bạn sẽ phải đều
thực hiện và nộp lên — cái báo cáo cuối cùng là theo từng cá nhân.

 Thì đầu tiên, các bạn sẽ có một cái là cài đặt cá nhân — là tất cả mọi
thứ chạy trên máy cá nhân của bạn. Thì các bạn sẽ tìm hiểu về các khái
niệm NameNode, DataNode nè. Và các bạn cài đặt, sau đó các bạn chạy thử,
 các bạn nắm ha. Đây, các bạn sẽ đọc cái đề đây nè. Đó, nó có cái link
hướng dẫn cài đặt — thì ờ, do trong lớp mình nó sẽ có rất là nhiều hệ
điều hành khác nhau, các bạn xài máy khác nhau, các bạn xài Windows và
macOS. Thì các bạn lựa cho mình các đường link hướng dẫn phù hợp để cài
đặt ha.

 Rồi ờ, trên lớp cô Thảo có nói cho các bạn về Hadoop chưa, hay là cô
Thảo chỉ mới giới thiệu về Hadoop thôi? Rồi, các bạn biết rồi đúng
không? Thì các bạn hình dung ha — một cái hệ thống dữ liệu phân tán thì
bản chất, nếu mà các bạn chạy single-node cluster này, có nghĩa là bạn
chạy trên máy local của bạn, thì tất cả mọi thứ nó chỉ xử lý trên một
máy thôi, nó không có gọi là phân tán. Phân tán nghĩa là sao? Ví dụ bạn
có một nhóm năm người thì bạn phải có một cái máy chủ và bốn cái máy con
 — ví dụ vậy. Thì lúc xử lý, có nghĩa là tất cả mọi thứ nó sẽ thông qua
cái máy chủ này để điều phối, với cái máy con xử lý.

 Rồi các bạn hình dung ha, thì ở đây nó sẽ có cái link khác. Để mình gửi
 cái link này vô cho các bạn ha. Đây, cái này là về cái link
single-node. Do trong bài Lab thì thầy Đăng chỉ để cho các bạn link về
cài đặt thôi. Còn cái này là về cái setup multi-node — thì khi các bạn
cài cái này ha, là các bạn phải chạy một lúc là chạy trên nhiều máy. Có
nghĩa là ví dụ nhóm bạn có năm người đúng không? Thì các bạn phải cài
được bốn máy con và một máy chủ. Sau đó các bạn sẽ report lại cho mình.
Report cái gì? Có nghĩa là các cái lệnh đây — trong đây các bạn phải
report các cái lệnh các bạn chạy khi các bạn cài đặt nè. Và các cái vấn
đề — có nghĩa là khi mà các bạn cài, đúng không, nó sẽ xảy ra lỗi. Tại
vì mỗi máy sẽ có vấn đề cài đặt khác nhau — mỗi máy nó sẽ có một cái lỗi
 khác nhau. Thì khi các bạn cài đặt, các bạn phải log lại từng cái lỗi
đi, theo cá nhân nha các bạn. Đi theo từng cá nhân, các bạn log lại lỗi
và đưa vào cái báo cáo giúp mình.

 Thì khi mà các bạn cài, trên [Drive/Moodle] thầy Đăng có để một cái cho
 các bạn đây — các bạn sẽ có cái file [Hadoop test] này nè. Khi các bạn
cài, ở trong đây các bạn follow cái file này ha. Thì trong bài Lab, ở
cái phần đầu đây, nó sẽ có cái hướng dẫn là khi các bạn cài xong, đúng
không, các bạn tạo cái folder với cái đường dẫn HDFS như này nè, các bạn
 sẽ chạy cái file .jar của thầy Đăng và nó sẽ trả ra cho các bạn một cái
 file output. Cái file này thì từng bạn trong nhóm nhớ giúp mình là các
bạn đều phải chạy — tại vì mỗi bạn khi chạy cái lệnh này ra nó sẽ trả ra
 một cái địa chỉ IP máy, thì cái IP máy của các bạn là khác nhau. Nên là
 các bạn phải tự chạy để ra cái IP máy của mình. Nếu trong trường hợp mà
 IP của các bạn trùng nhau thì bài đó sẽ bị không điểm.

 Rồi, tới đây có bạn nào có thắc mắc gì không về phần cài đặt? Phần cài
đặt thì các bạn sẽ follow theo cái hướng dẫn trong bài và các bạn cài
đặt theo đó. Nếu các bạn có lỗi thì các bạn log lại cái lỗi đó vô báo
cáo giúp mình. Có bạn nào có thắc mắc hay vấn đề gì về phần này không?

 Rồi nếu không có thì qua phần kế tiếp ha. Chỉ biết phần này là cài đặt
thôi thì không có gì. Tiếp theo, các bạn cài xong ha, các bạn sẽ phải có
 một cái là mấy bạn chạy thử. Thì cái bài thường dùng trong mỗi năm là
bài WordCount. Có nghĩa là các bạn cài xong, các bạn sẽ chạy thử coi là
các bạn chạy được cái dữ liệu phân tán không.

 Thì ở đây nó sẽ có một cái bài gọi là WordCount — đây, các bạn vào đây
nó sẽ có cái file .txt nè. Nó sẽ có một đống các từ, và sau đó các bạn
sẽ lấy cái từ đây. Bài WordCount nó sẽ hoạt động như sau: Ví dụ các bạn
có một cái danh sách từ ha — đây là cái input. Thì mỗi từ nó sẽ có chữ
cái đầu tiên — các bạn sẽ dựa vô cái cụm từ là [filter hw?]. Các bạn lọc
 ra các từ nào có chữ cái bắt đầu theo tám cái chữ cái này. Các bạn đưa
vô cái MapReduce — cô Thảo chắc nói các bạn về cái MapReduce chạy trong
Hadoop rồi, đúng không?

 Thì cái ý tưởng là sao? Khi mà các bạn đưa vô MapReduce, thì ở phase
Map nó sẽ thực hiện là nó tách theo cái khái niệm gọi là key và value.
Thì cái key ở đây là gì? Các bạn loop qua mỗi dòng của cái file .txt đó —
 đây, mỗi dòng. Xong, các bạn lấy key là cái chữ cái đầu tiên
