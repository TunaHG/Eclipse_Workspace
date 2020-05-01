package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * BOJ 14889 : https://www.acmicpc.net/problem/14889
 * N(짝수)명의 인원이 주어진다면, N/2명의 인원으로 구성된 2팀을 구성
 * 2팀이 구성된다면, 각 팀의 점수를 합산하여 두 팀의 차이를 탐색
 * 차이의 최소값을 결과로 출력
 * 
 * N/2명의 인원을 선택하여 1팀을 구성하면, 2팀의 구성원은 자동으로 확정
 * 1팀과 2팀을 구분하는 방법, visited[]를 이용? true라면 1팀, false라면 2팀
 * 팀의 인원이 완성되면, 두 팀의 값을 비교
 */
public class Q14889 {
	// 인원수 입력받을 변수
	static int N;
	// 각 인원의 능력치를 입력받을 변수
	static int[][] teamAbility;
	// true, false로 1팀, 2팀을 구분할 변수
	static boolean[] team;
	// 최종결과로 출력할 최소값 변수
	static int minResult = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 인원수 입력
		N = Integer.parseInt(br.readLine());
		// 팀의 인원수에 맞게 배열 선언, 각 팀의 번호를 그대로 사용할 예정이므로 1칸씩 더 크게 설정
		teamAbility = new int[N + 1][N + 1];
		team = new boolean[N + 1];
		// 배열 입력
		for(int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				teamAbility[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}
		
		// 1팀의 첫번째인원을 넣어줌
		for(int i = 1; i <= N; i++) {
			// 첫번째 인원이 1팀이란것을 표시
			team[i] = true;
			DFS(i, 1);
			// DFS종료후 i번째 인원을 false로 변경
			team[i] = false;
		}
		// 결과 출력
		System.out.println(minResult);
	}
	// 1팀에 포함될 인원을 의미하는 target, 1팀의 인원수를 의미하는 teamSize
	public static void DFS(int target, int teamSize) {
		// 1팀의 인원수가 전체 인원의 절반이라면 조건충족
		if(teamSize == N / 2) {
			// 각 팀의 전체능력치 선언 및 초기화
			int firstTeamAbilitySum = 0;
			int secondTeamAbilitySum = 0;
			// 각 팀의 능력치를 더해줄 반복문
			for(int i = 1; i <= N; i++) {
				// j는 i이후의 인원을 탐색
				for(int j = i + 1; j <= N; j++) {
					// i와 j의 팀이 같다면 과정 진행
					if(team[i] == team[j]) {
						// 해당 과정에서 (i, j)와 (j, i)를 동시에 넣어주므로 
						// j의 탐색을 1부터 N까지 진행하지 않고 i+1부터 N까지 진행한다.
						// i가 1팀이라면, j도 당연히 1팀이므로 i와 j의 팀 능력치를 1팀의 전체능력치에 추가
						if(team[i]) {
							firstTeamAbilitySum += teamAbility[i][j] + teamAbility[j][i];
						}
						// i가 2팀이라면, j도 당연히 2팀이므로 i와 j의 팀 능력치를 2팀의 전체능력치에 추가
						else {
							secondTeamAbilitySum += teamAbility[i][j] + teamAbility[j][i];
						}
					}
				}
			}
			// 1팀과 2팀의 전체능력치 차이값
			int diff = Math.abs(firstTeamAbilitySum - secondTeamAbilitySum);
			// 최소값 탐색
			minResult = Math.min(minResult, diff);
			// 해당 DFS 종료
			return ;
		}
		// 입력받은 인원 다음인원부터 DFS를 진행하여 탐색수 줄이기
		for(int i = target + 1; i <= N; i++) {
			team[i] = true;
			DFS(i, teamSize + 1);
			team[i] = false;
		}
	}
}
