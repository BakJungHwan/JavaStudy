package basic.arr;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Array1DScore {
	public static void main(String[] args) {
		Random rd = new Random(System.nanoTime());
		
		String[] GENDER = {"남성", "여성"};
		
		// 성적 자료 구성
		String[] name = {"원빈", "현빈", "골빈", "커피빈", "미스터빈"};
		
		int[] schoolClass = new int[name.length];
		
		int[] kor = new int[name.length];
		int[] eng = new int[name.length];
		int[] mat = new int[name.length];
		int[] sum = new int[name.length];
		int[] gen = new int[name.length];
		double[] avg = new double[name.length];
		
		// 점수범위, 반범위 설정
		final int scoreBound=100;
		final int classBound=3;
		
		// 과목별 점수, 반 입력
		for(int i=0; i<name.length; ++i)
		{
			schoolClass[i] = rd.nextInt(classBound)+1;
			kor[i] = rd.nextInt(scoreBound);
			eng[i] = rd.nextInt(scoreBound);
			mat[i] = rd.nextInt(scoreBound);
			gen[i] = rd.nextInt(2);
			sum[i] = kor[i]+eng[i]+mat[i];
			avg[i] = sum[i]/3.0;
		}
		
		// 컬럼별 점수 합과 평균 산출
			// colSums : 0:국어, 1:영어, 2:수학, 3:총점
			int[] colSums=new int[name.length-1];
			double colAvgsum=0.0;
				
			for(int i=0; i<name.length; ++i)
			{
				colSums[0] += kor[i];
				colSums[1] += eng[i];
				colSums[2] += mat[i];
				colSums[3] += sum[i];
				colAvgsum += avg[i];
			}
			
			// colAvgs : 0:국어, 1:영어, 2:수학, 3:총점
			double[] colAvgs = new double[name.length];
			for(int i=0; i<name.length-1; ++i)
			{
				colAvgs[i] = (int)((colSums[i]/name.length+0.005)*100)/100.0;
			}
			double avgAvg = (int)((colAvgsum/name.length+0.005)*100)/100.0;
		
			// 전체등수 산출
			int[] rank = {1,1,1,1,1};
			for(int i=0; i<name.length; ++i)
			{
				for(int j=0; j<name.length; ++j)
				{
					if(sum[i]<sum[j])
					{
						++rank[i];
					}
				}
			}
			

			
///////////////////////////////////////////////////////////////////// 산출부 끝/////////////////////
			////////////////////////////////////// 출력부 시작 ////////////////////////////////////////////////////
			
		
		// 번호기준 출력
		System.out.println("번호기준 출력");
		System.out.println("번호\t성명\t성별\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------------------------------------");
		for(int i=0; i<name.length; ++i)
		{
			System.out.print(i + "\t");
			System.out.print(name[i] + "\t");
			System.out.print(GENDER[gen[i]] + "\t");
			System.out.print(kor[i] + "\t");
			System.out.print(eng[i] + "\t");
			System.out.print(mat[i] + "\t");
			System.out.print(sum[i] + "\t");
			System.out.println((int)((avg[i]+0.005)*100)/100.0 + "\t");
		}
		
		
		// 컬럼별 총계와 평균 출력
		System.out.println("-----------------------------------------------------------------------------");
		System.out.print("총계\t\t\t");
				
		for(int i=0; i<colSums.length; ++i)
		{
			System.out.print(colSums[i] + "\t");
		}
		System.out.println((int)((colAvgsum+0.005)*100)/100.0 + "\t");
		
		System.out.print("평균\t\t\t");
		for(int i=0; i<name.length-1;++i)
		{
			System.out.print(colAvgs[i]+"\t");
		}
		System.out.println(avgAvg + "\t");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		

		
		// 전체등수 기준 출력
		System.out.println("전체등수 기준 출력");
		System.out.println("전체등수\t번호\t성명\t성별\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------------------------------------");
				
		
		for(int i=0; i<name.length; ++i)
		{
			for(int j=0;j<name.length;++j)
			{
				
				if(i+1 == rank[j])
				{
					System.out.print(rank[j] + "\t");
					System.out.print(j + "\t");
					System.out.print(name[j] + "\t");
					System.out.print(GENDER[gen[j]] + "\t");
					System.out.print(kor[j] + "\t");
					System.out.print(eng[j] + "\t");
					System.out.print(mat[j] + "\t");
					System.out.print(sum[j] + "\t");
					System.out.println((int)((avg[j]+0.005)*100)/100.0 + "\t");
				}
			}
		}
		// 컬럼별 총계와 평균 출력
				System.out.println("-----------------------------------------------------------------------------");
				System.out.print("총계\t\t\t\t");
						
				for(int i=0; i<colSums.length; ++i)
				{
					System.out.print(colSums[i] + "\t");
				}
				System.out.println((int)((colAvgsum+0.005)*100)/100.0 + "\t");
				
				System.out.print("평균\t\t\t\t");
				for(int i=0; i<name.length-1;++i)
				{
					System.out.print(colAvgs[i]+"\t");
				}
				System.out.println(avgAvg + "\t");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
		
		
				
				
		// 반별등수 산출
		int[] classStuRank = new int[name.length];
		for(int i=0; i<name.length; ++i)
		{
			classStuRank[i] = 1;
		}
		
		
		for(int i=0; i<name.length; ++i)
		{
			for(int j=0; j<name.length; ++j)
			{
				if(schoolClass[i]==schoolClass[j] && sum[i]<sum[j])
				{
					++classStuRank[i];
				}
			}
		}

		// 반별, 반별등수별 출력
		System.out.println("반별등수 및 반등수 출력");
		double[] classAvgs = new double[classBound];
		for(int i=0; i<classBound; ++i)
		{
			classAvgs[i]=-1;
		}
		
		for(int i=1;i<=classBound;++i)
		{
			int count=0;
			for(int j=0; j<name.length; ++j)
			{
				if(schoolClass[j]==i)
				{
					++count;
				}
			}
			
			if(count == 0)	continue;
			
			int[] classColSum = new int[name.length-1];
			double classAvgSum =0.0;
			System.out.println("반\t반등수\t전체등수\t번호\t성명\t성별\t국어\t영어\t수학\t총점\t평균");
			System.out.println("------------------------------------------------------------------------------------");
			
			for(int j=0; j<count; ++j)
			{
				int findRank = j+1;
				for(int k=0; k<name.length; ++k)
				{
					if(schoolClass[k]==i && classStuRank[k]==findRank)
					{
						System.out.print(schoolClass[k] + "\t");
						System.out.print(classStuRank[k] + "\t");
						System.out.print(rank[k]+"\t");
						System.out.print(k + "\t");
						System.out.print(name[k] + "\t");
						System.out.print(GENDER[gen[k]] + "\t");
						System.out.print(kor[k] + "\t");
						System.out.print(eng[k] + "\t");
						System.out.print(mat[k] + "\t");
						System.out.print(sum[k] + "\t");
						System.out.println((int)((avg[k]+0.005)*100)/100.0 + "\t");
						
						classColSum[0] += kor[k];
						classColSum[1] += eng[k];
						classColSum[2] += mat[k];
						classColSum[3] += kor[k] + eng[k] + mat[k];
						classAvgSum += avg[k];
					}
				}
			}
			
			double[] classColAvg = new double[name.length-1];
			for(int j=0; j<name.length-1; ++j)
			{
				classColAvg[j] = (int)((classColSum[j]/count+0.005)*100)/100.0;
			}
			
			// 반별 순위 체크를 위해 점수저장
			classAvgs[i-1] = classColAvg[3];
			
			double classAvgAvg = (int)((classAvgSum/count+0.005)*100)/100.0;
						
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.print("총계\t\t\t\t\t\t");
			for(int j=0; j<name.length-1; ++j)
			{
				System.out.print(classColSum[j] + "\t");
			}
			System.out.println((int)((classAvgSum+0.005)*100)/100.0 + "\t");
			
			System.out.print("평균\t\t\t\t\t\t");
			for(int j=0; j<name.length-1; ++j)
			{
				System.out.print(classColAvg[j] + "\t");
			}
			System.out.println((int)((classAvgAvg+0.005)*100)/100.0 + "\t");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
		}
		
		// 반별 등수 산출
		int[] classRank = new int[classBound];
		for(int i=0; i<classBound; ++i)
		{
			classRank[i] = 1;
		}
		
		for(int i=0; i<classBound; ++i)
		{
			if(classAvgs[i]==-1)
			{
				classRank[i] = -1;
				continue;
			}
			for(int j=0; j<classBound; ++j)
			{
				if(classAvgs[i]<classAvgs[j])
				{
					++classRank[i];
				}
			}
		}
		
		// 반별 등수 출력
		for(int i=0; i<classBound; ++i)
		{
			if(classRank[i]!=-1)
			{
				System.out.print(i+1 + "반 : " + classRank[i] + "등\t\t");
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	
		

		// 성별등수 산출
		int[] genStuRank = new int[name.length];
		for(int i=0; i<name.length; ++i)
		{
			genStuRank[i] = 1;
		}
		
		
		for(int i=0; i<name.length; ++i)
		{
			for(int j=0; j<name.length; ++j)
			{
				if(gen[i]==gen[j] && sum[i]<sum[j])
				{
					++genStuRank[i];
				}
			}
		}

		// 성별 등수 기준 출력
		System.out.println("성별등수 기준 출력");
		double[] genAvgs = new double[GENDER.length];
		for(int i=0; i<GENDER.length; ++i)
		{
			genAvgs[i]=-1;
		}
		
		for(int i=0;i<GENDER.length;++i)
		{
			int count=0;
			for(int j=0; j<name.length; ++j)
			{
				if(gen[j]==i)
				{
					++count;
				}
			}
			
			if(count == 0)	continue;
			
			int[] genColSum = new int[name.length-1];
			double genAvgSum =0.0;
			System.out.println("성별\t성별등수\t전체등수\t반\t번호\t성명\t성별\t국어\t영어\t수학\t총점\t평균");
			System.out.println("--------------------------------------------------------------------------------------------------");
			
			for(int j=0; j<count; ++j)
			{
				int findRank = j+1;
				for(int k=0; k<name.length; ++k)
				{
					if(gen[k]==i && genStuRank[k]==findRank)
					{
						System.out.print(GENDER[gen[k]] + "\t");
						System.out.print(genStuRank[k] + "\t");
						System.out.print(rank[k]+"\t");
						System.out.print(schoolClass[k]+"\t");
						System.out.print(k + "\t");
						System.out.print(name[k] + "\t");
						System.out.print(GENDER[gen[k]] + "\t");
						System.out.print(kor[k] + "\t");
						System.out.print(eng[k] + "\t");
						System.out.print(mat[k] + "\t");
						System.out.print(sum[k] + "\t");
						System.out.println((int)((avg[k]+0.005)*100)/100.0 + "\t");
						
						genColSum[0] += kor[k];
						genColSum[1] += eng[k];
						genColSum[2] += mat[k];
						genColSum[3] += kor[k] + eng[k] + mat[k];
						genAvgSum += avg[k];
					}
				}
			}
			
			double[] genColAvg = new double[name.length-1];
			for(int j=0; j<name.length-1; ++j)
			{
				genColAvg[j] = (int)((genColSum[j]/count+0.005)*100)/100.0;
			}
			
			double genAvgAvg = (int)((genAvgSum/count+0.005)*100)/100.0;
						
			
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.print("총계\t\t\t\t\t\t\t");
			for(int j=0; j<name.length-1; ++j)
			{
				System.out.print(genColSum[j] + "\t");
			}
			System.out.println((int)((genAvgSum+0.005)*100)/100.0 + "\t");
			
			System.out.print("평균\t\t\t\t\t\t\t");
			for(int j=0; j<name.length-1; ++j)
			{
				System.out.print(genColAvg[j] + "\t");
			}
			System.out.println((int)((genAvgAvg+0.005)*100)/100.0 + "\t");
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
		}
		
		
		// 반, 성별, 등수
		
		// 교련 수강 여부를 통한 남녀 구분
		
		
		
		
		
		System.out.println();
		
		
	}
}
