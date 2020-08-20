let index = { // 변수는 let쓰고 /index라는 obeject만들었다.
		init : function(){
			//여기 등록되는게 리스너임
			//console.log(this); // 인덱스
			//let _this=this;
			//여기 등록되는게 리스너임 1번 리스너
			$("#btn-save").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				//callback 스택
				console.log(this); // 버튼
				this.save();
			});
			
			$("#btn-login").on("click", ()=>{ // 리스너가 계속 지켜보고 있음.
				//callback 스택
				console.log(this); // 버튼
				this.login();
			});
					
		},

		save : function(){
			let data = {
					username:$('#username').val(),
					password:$('#password').val(),
					email:$('#email').val()
			};
			$.ajax({
				type: "POST",
				url:"/auth/joinProc",
				data:JSON.stringify(data), // JSON으로 바껴서 날라감.
				contentType: "application/json; charset=utf-8",
				dataType: "json" /* 서버로 부터 응답받을 때 데이터 타입 */
			}).done((resp)=>{
				
					alert("회원가입이 성공");
					location.href="/";
				
				console.log(resp);
				//console.log(JSON.parse(resp));
			}).fail(function(error){
				alert("회원가입 실패");
				console.log(error);
			}) // fetch 써도 됨.
		},
		
		login : function(){
			let data = {
					username:$('#username').val(),
					password:$('#password').val()					
			};
			$.ajax({
				type: "POST",
				url:"/auth/loginProc",
				data:JSON.stringify(data), // JSON으로 바껴서 날라감.
				contentType: "application/json; charset=utf-8",
				dataType: "json" /* 서버로 부터 응답받을 때 데이터 타입 */
			}).done((resp)=>{
				if(resp.statusCode ==1){
					alert("로그인 성공");
					location.href="/";
				}else{
					alert("아이디와 패스워드를 다시 입력하세요");
					console.log(resp);
				}
				//console.log(JSON.parse(resp));
			}).fail(function(error){
				alert("로그인 실패");
				console.log(error);
			})
		}
		
		
		
		

}
index.init();

// 한 페이지 안에 있는거 한 object에 다 추가 해두면 함수명 충돌날 일도 없고 좋아요.