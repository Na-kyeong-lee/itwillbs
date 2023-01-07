<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>menuList</title>
<style>
</style>
<link rel="stylesheet" type="text/css" href="./css/default.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">

</head>

<body>
	<!-- header -->

	<!-- 추천상품 -->





	<!-- 카테고리 -->
	<!-- <input type="radio" id="category_1" name="category_1" value="카테고리1"> -->
	<!-- <label for="category_1">카테고리1</label> -->
	<!-- <input type="radio" id="category_2" name="category_2" value="카테고리2"> -->
	<!-- <label for="category_2">카테고리2</label> -->
	<!-- <input type="radio" id="category_3" name="category_3" value="카테고리3"> -->
	<!-- <label for="category_3">카테고리3</label> -->
	<!-- <input type="radio" id="category_4" name="category_4" value="카테고리4"> -->
	<!-- <label for="category_4">카테고리4</label> -->


	<div class="category_select">
		<form action="" method="post">
			<fieldset>
				<!-- 관련컨텐츠를 하나의 그룹으로 묶음 -->
				<legend> 분류보기 </legend>
				<!-- fieldset의 제목 명령어 -->

				<ul class="cate_list">
					<!--  순서없는 항목  -->
					<li><input type="radio" style='vertical-align: middle;'
						name="category_1" id="category_all" checked="checked"> <label
						for="category_all">모두보기</label></li>

					<li><input type="radio" style='vertical-align: middle;'
						name="category_1" id="category_1"> <label for="category_1">카테고리1</label></li>

					<li><input type="radio" style='vertical-align: middle;'
						name="category_1" id="category_2"> <label for="category_2">카테고리2</label></li>

					<li><input type="radio" style='vertical-align: middle;'
						name="category_1" id="category_3"> <label for="category_3">카테고리3</label></li>

				</ul>
			</fieldset>
		</form>
	</div>


	<!-- 상세메뉴 -->
	<ul class="menuList">
		<li >
			<dl>
				<dt style="text-align: center;">메뉴_01</dt>
				<dd class="img">
					<img src="../4608976_1.webp" width="300" height="300" alt="">
				</dd>
				<dd>가격</dd>
				<dd>
					<div>
						수량 <input type="number" step="1" min="0" style="text-align: left; width:40px; height:17px;">

						<button>
							<a href="#" onclick="" class="buttonGray">담기
						</button>
						</a>
						<!-- 						ajax -->
					</div>
				</dd>
				<dd></dd>
			</dl>
		</li>
	</ul>

	<ul class="menuList">
		<li>
			<dl>
				<dt style="text-align: center;">메뉴_01</dt>
				<dd class="img">
					<img src="../4608976_1.webp" width="300" height="300" alt="">
				</dd>
				<dd>가격</dd>
				<dd>
					<div>
						수량 <input type="number" step="1" size="2" min="0"style="text-align: left; width:40px; height:17px;">

						<button>
							<a href="#" onclick="" class="buttonGray">담기
						</button>
						</a>
						<!-- 						ajax -->
					</div>
				</dd>
				<dd></dd>
			</dl>
		</li>
	</ul>

	<ul class="menuList">
		<li>
			<dl>
				<dt style="text-align: center;">메뉴_01</dt>
				<dd class="img">
					<img src="../4608976_1.webp" width="300" height="300" alt="">
				</dd>
				<dd>가격</dd>
				<dd>
					<div>
						수량 <input type="number" step="1" size="2" min="0"style="text-align: left; width:40px; height:17px;">

						<button>
							<a href="#" onclick="" class="buttonGray">담기
						</button>
						</a>
						<!-- 						ajax -->
					</div>
				</dd>
				<dd></dd>
			</dl>
		</li>
	</ul>

	<ul class="menuList">
		<li>
			<dl>
				<dt style="text-align: center; ">메뉴_01</dt>
				<dd class="img">
					<img src="../4608976_1.webp" width="300" height="300" alt="">
				</dd>
				<dd>가격</dd>
				<dd>
					<div>
						수량 <input type="number" step="1" size="2" min="0"style="text-align: left; width:40px; height:17px;">

						<button>
							<a href="#" onclick="" class="buttonGray">담기
						</button>
						</a>
						<!-- 						ajax -->
					</div>
				</dd>
				<dd></dd>
			</dl>
		</li>
	</ul>













</body>
</html>