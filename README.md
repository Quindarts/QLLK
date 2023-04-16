# Project Quản lý Linh Kiện
Quy trình làm việc với git của team dự án:

Code chính sẽ nằm ở nhánh main (server)

Code sau khi được thành viên trong nhóm review done sẽ đc tạo merge request lên nhánh main

Để bắt đầu code thành viên checkout sang nhánh master tại local sau đó pull code từ main (hoặc server) về và tạo nhánh mới 

Các thành viên trong nhóm sau khi code mỗi chức năng sẽ commit lại và mô tả đúng với công việc trong commit đó để người review dễ theo dõi (lưu ý k làm nhiều chức năng lớn rồi mới commit 1 lần vì rất khó theo dõi cho người review)

Khi merge bị conflict sẽ tạo 1 nhánh mới và checkout sang nhánh mới mình sẽ xử lý conflict trên nhánh vừa tạo, sau khi hoàn tất checkout sang nhánh code và commit, push lại code ở nhánh để xử lí conflict sẽ đc đẩy lên nhánh release (để đề phòng việc resolve ảnh hưởng đến code của người khác)

Việc review sẽ là review chéo giữa các thành viên, nhờ người khác review cũng như xin merge bằng cách sau:

Copy link merge request sau đó dán vào phần comment trong tast và gửi link task vào nhóm thảo luận, nhắc đến trực tiếp người muốn nhờ review để k bị trôi tin nhắn( việc review code cho người khác cũng là cách để mình học hỏi và tiến bộ hơn trong cách code )

Sau khi review xong thì phải phản hồi lại cho người khác( có thể nhắn tin riêng để trao đổi)
