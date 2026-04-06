Báo cáo phân tích (analysis.md)
Câu hỏi 1:

Thông báo lỗi đăng nhập phải lưu vào Request Scope vì chỉ cần tồn tại trong 1 lần request.

Nếu lưu nhầm vào Session Scope, thông báo sẽ “dính” suốt cả phiên, kể cả khi người dùng đã đăng nhập thành công → gây trải nghiệm sai.

Câu hỏi 2:

totalViewCount phải lưu vào Application Scope để tất cả nhân viên cùng nhìn thấy một con số chung.

Nếu lưu vào Session Scope, mỗi nhân viên sẽ có bộ đếm riêng biệt → ví dụ A thấy 1, B thấy 1, thay vì tổng cộng 2.

Câu hỏi 3:

Race Condition: tình huống nhiều luồng cùng truy cập và cập nhật một biến toàn cục, dẫn đến kết quả sai.

Đoạn code:

java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
Khi nhiều người dùng truy cập đồng thời, hai luồng có thể đọc cùng một giá trị cũ rồi cùng tăng → mất lượt tăng.

Cách phòng tránh: dùng cơ chế đồng bộ, ví dụ AtomicInteger lưu trong Application scope, hoặc đồng bộ hóa đoạn code cập nhật.