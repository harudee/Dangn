<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>

	<section id="content">
		<section id="result">
			<h1 class="head-title" id="hot-articles-head-title">중고거래 인기매물</h1>

			<section class="cards-wrap">

				<c:forEach items="${products}" var="product" varStatus="st">

					<article class="card-top ">
						<div class="card-photo ">
							<a class="card-link" href=""></a> <img alt="위닉스 제습기 16리터 팝니다"
								src="https://dnvefa72aowie.cloudfront.net/origin/article/202107/ea06fd0f1a31a9217a87e84e6dc1840b9e87742068621bdd8cc5955258ecb334.webp?q=82&amp;s=300x300&amp;t=crop" />
						</div>
						<div class="card-desc">
							<a class="card-title" href="/product/view/${product.itemid}">${product.itemname}</a>
							<div class="card-price ">${product.price}원</div>
							<div class="card-region-name">${product.user.username}</div>
							<div class="card-counts">
								<span> 관심 ${product.hitcount} </span> ∙ <span> 댓글 ${product.replycnt} </span>
							</div>
						</div>
					</article>

				</c:forEach>
			</section>
		</section>
	</section>
</body>
</html>