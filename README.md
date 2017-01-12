———————————— DỒ ÁN VN-PLAYER - ỨNG DỤNG CHƠI NHẠC ————————————

Một số yêu cầu khỉ làm: 
 1. tạo branch
	- checkout từ develop 
	- trước khi code, cdc bạn cần tạo branch riêng format sau: 
		+ với feature: feature/[tên ban]_[title]
			ex: feature/nnbinh_implement_main_screen
		+ fix bug: fixbug/[tên ban]_[title]
	- UT kĩ, remove những đoạn code không cần thiết. ví dụ: 
		+ những function, biến, thư viện đã khai báo nhưng không sử dụng 
	- chỉ code trên khi vực app. 
	- Nếu muốn chỉnh sửa j trên class có chữ “base” => cần confirm với mình 
	- Sử dụng fragment thay cho activity trừ những trường hợp đặc biệt. 
	- Nên kế thừa: 
		+ fragment extend BaseFragment
		+ activity extend BaseActivity 

2. luôn update mới nhất từ develop trước khi push 
3. tạo merged request (pull request) tới mình (merged từ nhánh của bạn vào develop)
4. hãy thông báo với mình, say khi song  