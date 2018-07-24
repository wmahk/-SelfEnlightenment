<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<!--JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<!-- HTML5の機能で入力検証を行うJSPサンプル -->
	<!-- 基本的にinputタグの中身を書き換えるだけでOK -->
	<!-- ↑のCSS、JSはbootstrapでの見栄えを良くするだけに読み込んでいるので書く必要はない -->

	<h2>HTML5で行う入力検証</h2>
	<hr>

	<!-- 見やすいようにbootstrapのグリットの調整 -->
	<div class="container">
		<div class="row">
			<form action="" method="post">
				<div class="col-md-4">
					<div class="well">


					<!-- 入力項目作成ここから -->

						<p>◆名前入力系</p>

						<!--全角文字のみを許容する書き方(特殊文字は許容してしまう)-->
						<!-- patternに[^\x20-\x7E]*を設定することで、半角英数字を全て弾くことが出来る -->
						<!-- ↑はすべてのASCII文字に一致する正規表現 -->
						<!-- requiredを書くことで必須項目になる(空欄チェック) -->
						名前(全角)<input type="text" name="name" pattern="[^\x20-\x7E]*"
							class="form-control" required>※必須<br>

						<!--ひらがなのみ許容する書き方-->
						<!-- patternに[\u3041-\u3096]*を設定することで、ひらがなのみを通すことができる -->
						名前(ひらがな) <input type="text" name="name_hiragana"
							pattern="[\u3041-\u3096]*" class="form-control"> <br>

						<!--全角カタカナのみ許容する書き方-->
						<!-- patternに[\u30A1-\u30F6]*を設定することで、全角カタカナのみを通すことができる -->
						名前(全角カタカナ) <input type="text" name="name_katakana"
							pattern="[\u30A1-\u30F6]*" class="form-control"> <br>

						<!--半角カタカナのみ許容する書き方-->
						<!-- patternに[\u30A1-\u30F6]*を設定することで、半角カタカナのみを通すことができる -->
						名前(半角カタカナ) <input type="text" name="name_h_katakana"
							pattern="[\uFF66-\uFF9F]*" class="form-control"> <br>

						<!--半角カタカナのみ許容する書き方-->
						<!-- patternに^[A-Za-z]+$を設定することで、半角アルファベットのみを通すことができる -->
						<!-- pattern内のA-Zを消せば小文字だけ、a-zを消せば大文字だけ通すようになる -->
						名前(半角アルファベット) <input type="text" name="name_h_katakana"
							pattern="^[A-Za-z]+$" class="form-control"> <br>
					</div>
				</div>

				<!-- 見栄えの調整 -->
				<div class="col-md-4">
					<div class="well">


						<p>◆個人情報入力系</p>
						<!-- 年齢入力(上限、下限) -->
						<!-- type="number"で数字のみを許容 -->
						<!-- max,min属性で上限と下限を設定することができる -->
						年齢(18~100歳まで)<input type="number" min="18" max="100" name="age"
							class="form-control"><br>

						<!-- メールアドレス -->
						<!-- type="email"でメールアドレスのみを許容 -->
						<!-- 〇〇@△△ のようにアットマークが入らないと弾かれる -->
						メールアドレス<input type="email" name="email" class="form-control"><br>

						<!-- パスポート番号 -->
						<!-- patternに[0-9A-Za-z]{9}を設定することで、半角英数字のみ9桁を通すことができる -->
						パスポート番号(半角英数字9桁)<input type="text" name="passport_num"
							pattern="[0-9A-Za-z]{9}" class="form-control"> <br>

						<!-- 郵便番号 -->
						<!-- patternに\d{3}-\d{4}を設定することで、半角英数字3桁-4桁の組み合わせのみを通すことができる -->
						郵便番号(ハイフンあり)<input type="text" name="postal_code"
							pattern="\d{3}-\d{4}" class="form-control"> <br>

						<!-- 電話番号 -->
						<!-- patternに\d{2,4}-\d{3,4}-\d{3,4}を設定することで、電話番号の組み合わせのみを通すことできる -->
						電話番号(ハイフンあり)<input type="text" name="phone_number"
							pattern="\d{2,4}-\d{3,4}-\d{3,4}" class="form-control"> <br>




					</div>
				</div>
				<!--送信ボタン-->
				<input type="submit" class="form-control btn-info">
			</form>
		</div>

	</div>


</body>
</html>