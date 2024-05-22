<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>

	#attach-zone {
		border: 1px solid var(--border-color); 
		background-color: var(--back-color);
		width: 300px;
		height: 100px;
		overflow: auto;
	}
	
	#attach-zone .item {
		font-size : 14px;
		margin : 5px 10px;
	
	}

</style>
</head>
<body>
	<h1>파일 업로드(단일)</h1>
	
	<form method="POST" action="/file/addok.do" enctype="multipart/form-data" id="form1">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach"></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	</form>
	
	<hr>
	
	<h1>파일 업로드(다중 > multiple)</h1>
	
	<form method="POST" action="/file/multi_addok.do" enctype="multipart/form-data" id="form2">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach" multiple></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	</form>
	
	<hr>
	
	<h1>파일 업로드(다중 > File Drop)</h1>
	
	<form method="POST" action="/file/multi_addok.do" enctype="multipart/form-data" id="form3">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<div id="attach-zone"></div>
			<input type="file" name="attach" style="display:none;">
			</td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	</form>
	
	<hr>
	
	<h1>파일 업로드(다중 > ajax)</h1>
	
	<form id="form4">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach" multiple></td>
		</tr>
	</table>
	<div>
		<button type="button">보내기</button>
	</div>
	</form>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
	
	
		function checkFile(filename, filesize) {
			
			const maxsize = 10485760; // 10MB
			const regex = /(.*?)\.(exe|sh)$/gi; // test.exe, test.sh  확장자 정규식
			
			
			if (filesize > maxsize) {
				
				alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
				
				return true;

			}
			
			if (regex.test(filename)) {
				
				alert('해당 파일은 업로드할 수 없습니다.');
				
				return true;
				
			}
			
			return false;
			
		}	
	
	
		//폼이 전송되기 직전
		$('#form1').submit(() => {
			
			//C:\fakepath\highlight.zip
			//alert($('input[name=attach]').val());
			// alert($('input[name=attach]')[0].files[0].name);
			
			//<input type="file" name="attach">
			//let filename = $('input[name=attach]')[0]
			
			//<input type="file" name="attach">
			let filename = $('input[name=attach]')[0].files[0].name;
			
			let filesize = $('input[name=attach]')[0].files[0].size;
			// alert(filesize);
			
			if (checkFile(filename, filesize)) {
				// 전송금지!!
				event.preventDefault();
				return false;
				
			}
			
			// submit 진행 
			
			
		});
		
		$('#form2').submit(() => {

			
		event.preventDefault();
			// 첨부파일 여러개 
			// $('#form2 input[name=attach]')[0].files.length);
		
		let totalSize = 0;
		
		// 배열 처럼 보이지만 진짜 배열이 아닌 유사배열이라서  forEach 안됨 > Array.from 로 진짜 배열 변환
		// 관리자 도구 TypeError: $(...)[0].files.forEach is not a function
		
		Array.from($('#form2 input[name=attach]')[0].files).forEach(file => {
			//alert(file.size);
			
			// 개별 파일 체크
			if (checkFile(file.name, file.size)) {
				alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
				event.preventDefault();
				return false;
				
			}
			
			totalSize += file.size;
			
			
		});
		
		if (totalSize > 52428800) {
			alert('총 파일의 크기의 합이 50MB 이하만 가능합니다.');
			event.preventDefault();
			return false;
			
		}
		
		
	});
	
	
	$('#attach-zone')
		.on('dragenter', e => {
			// 이벤트 동작 막기 (방해되서)
			e.preventDefault();
			e.stopPropagation();
		})
		.on('dragover', e => {
			e.preventDefault();
			e.stopPropagation();
		})
		.on('dragleave', e => {
			e.preventDefault();
			e.stopPropagation();
		})
		.on('drop', e => {
			e.preventDefault();
			
			//alert();
			
			// drag 한 파일
			const files = e.originalEvent.dataTransfer.files;
			
			if (files != null && files != undefined) {
				
				
				// 기존 드래그  파일 제거 
				$('#attach-zone').empty();
				
				let temp = '';
				
				for (let i=0; i<files.length; i++) {
						
					// console.log(files[i].name);
					
					let filename = files[i].name;
					let filesize = files[i].size / 1024 / 1024; // MB
					
					
					// 1MB 넘어가면 소수점 2자리 까지, 안넘어가면 1자리
					filesize = filesize < 1 ? filesize.toFixed(2) : filesize.toFixed(1);
					
					temp += `
						<div class="item">
							<span>\${filename}</span>
							<span>\${filesize}MB</span>
						</div>
					`;
								
					
				}//for
				
				
				$('#attach-zone').append(temp);
				
				
				// drag 한 파일 넣기 (const files)
				$('#form3 input[name=attach]').prop('files', files);
				
			}
			
		});
	
	
		
		$('#form4 button').click(() => {
		
			
			// Ajax 파일 업로드 > FormData 객체 사용
			// - IE 10 이후부터 지원
			// 모바일에서는 불가 
			
			const formData = new FormData();
			const files = $('#form4 input[name=attach]')[0].files;
			
			
			// console.log(files);
			// file 하나하나를 formData 에 넣기
			
			for (let i=0; i<files.length; i++) {
				
				// formData.append("name", value);
				formData.append("attach", files[i]);
				
			}
			
			// 홍길동
			formData.append("txt", $('#form4 input[name=txt]').val());
			
			$.ajax({
				
				type: 'POST',
				url : '/file/multi_addok.do',
				data: formData,
				processData: false,
				contentType: false,
				success: function(result) {
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		});
		
	
	
	
	</script>
</body>
</html>






















