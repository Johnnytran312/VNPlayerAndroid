———————————— DỒ ÁN VN-PLAYER - ỨNG DỤNG CHƠI NHẠC ————————————

I. Danh sách công việc 
	https://docs.google.com/spreadsheets/d/1iiIGkcMDnPhvqBE_7SI1YZ8Sbh5jay2gy5Q9DvO0Vl8/edit?usp=sharing

II. Thư mục đồ án (boo cáo, document, đánh giá, src ) 
    [cập nhật sau ]

III. Một số yêu cầu khỉ làm: 
 1. tạo branch
	- checkout từ develop 
	- trước khi code, các bạn cần tạo branch riêng format sau: 
		+ với feature: feature/[tên ban]_[title]
			ex: feature/nnbinh_implement_main_screen
		+ fix bug: fixbug/[tên ban]_[title]
	- UT kĩ, remove những đoạn code không cần thiết. ví dụ: 
		+ những hình ảnh, function, biến, thư viện đã khai báo nhưng không sử dụng 

	- chỉ code trên khi vực app. 
	- Nếu muốn chỉnh sửa j trên class có chữ “base” => cần confirm với mình 
	- Sử dụng fragment thay cho activity trừ những trường hợp đặc biệt. 
	- Nên kế thừa: 
		+ fragment extend BaseFragment
		+ activity extend BaseActivity 
	- các đoạn text, bạn cần chai bro wrong file string, không nên hard code
	- các hình ảnh, luan có tiền tố là ”ic_”, dung lượng nhỏ 

2. luôn update mới nhất từ develop trước khi push 
3. tạo merged request (pull request) (merged từ nhánh của bạn vào develop)
4. hãy thông báo với mình, sau khi song  

