package randomWord;

import java.util.Random;

public class RandomWord {
	String adjective = "거친 검은 게으른 고마운 고운 곧은 괜찮은 귀여운 그리운 기다란 기쁜 깊은 깨끗한 너그러운 너른 널따란 넓은 네모난 노란 높은 느린 늦은 더운 동그란 돼먹잖은 된 둥그런 둥근 뒤늦은 드문 딱한 때늦은 뛰어난 뜨거운 막다른 많은 매운 먼 멋진 메마른 메스꺼운 모난 못난 못된 못생긴 무거운 무딘 무른 무서운 미끈미끈한 미운 바람직스러운 반가운 밝은 밤늦은 보드라운 보람찬 보잘것없는 부드러운 부른 붉은 비싼 빠른 빨간 뻘건 뼈저린 뽀얀 뿌연 새로운 서툰 섣부른 설운 성가신 센 수다스러운 수줍은 쉬운 스스러운 슬픈 시원찮은 싫은 싼 쌀쌀맞은 쏜살같은 쓰디쓴 쓰린 쓴 아니꼬운 아닌 아름다운 아쉬운 아픈 안된 안쓰러운 안타까운 않은 알맞은 약빠른 약은 얇은 얕은 어두운 어려운 어린 언짢은 엄청난 없는 여문 열띤 예쁜 올바른 옳은 외로운 우스운 의심쩍은 이른 익은 있는 작은 잘난 잘빠진 잘생긴 재미있는 적은 젊은 점잖은 조그만 좁은 좋은 주제넘은 줄기찬 즐거운 지나친 지혜로운 질긴 짓궂은 짙은 짠 짧은 케케묵은 큰 탐스러운 턱없는 푸른 하나같은 한결같은 희망찬 흰 힘찬";
	String[] adArray = adjective.split(" ");

	String noun = "개 게 불 바람 아이스초코 계란밥 계란 물 바위 나무 마라탕";
	String[] nounArray = noun.split(" ");

	Random rd = new Random();
	
	public RandomWord() {
		super();
	}
	
	public String getAdjective() {
		System.out.println("형용사 사이즈" + adArray.length);
		return adArray[rd.nextInt(adArray.length)];
	}
	
	public String getNoun() {
		System.out.println("형용사 사이즈" + nounArray.length);
		return nounArray[rd.nextInt(nounArray.length)];
	}

}
