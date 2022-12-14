# Spring Batch 용어 정리

### Job

+ **배치처리 과정**을 하나의 단위로 만들어 놓은 객체이다.

### JobInstance

+ Job의 **실행을 단위**로 나타낸 것이다.
+ Job을 **실행**하면 하나의 JobInstance가 생성된다. 
+ JobInstance는 **각각 생성**되고, 실패하고 다시 실행해도 **하나의 데이터만 처리**한다.   

### **JobParameters**

+ JobParameters 객체로 **JobInstance를 구분**한다.
+ **형식**: String, Double, Long, Date

### JobExecution

+ **JobInstance에 대한 실행**을 시도하는 객체이다.
+ JobInstance가 재실행하면 **JobExecution**은 **개별로** 생긴다.

### Step 

+ **Job의 배치처리를 정의**하고 **순차적인 단계**를 **캡슐화**한다. 
+ **Job**은 **최소 1개 이상의 Step**을 가져야 한다. 
+ **Job**의 **실제 일괄 처리**를 제어하는 모든 정보가 들어있다.

### StepExecution

+ **Step 실행 시도**에 대한 객체를 나타낸다. 
+ Job이 여러개의 Step으로 구성되어 있으면, Step이 실패하면 **다음 단계가 실행되지 않음**으로 이후 **StepExecution은 생성되지 않는다.**

### ExecutionContext 

+ Job에서 **데이터를 공유**할 수 있는 **데이터 저장소**이다.
+ **JobExecutionContext**
  + Commit 시점에 저장된다.
+ **StepExecutionContext**
  +  실행 사이에 저장이 된다.

+ **마직막 실행 값**을 **재구성** 할 수 있다.
+ Step간 **Data 공유**가 가능하다.

### JobRepository 

+ **배치 처리 정보**를 **담고있는** 메커니즘이다. 
+ Job이 실행되면 **JobExecution과 StepExecution을 생성**한다.

### JobLauncher

+ Job과 JobParameters를 사용해 **Job을 실행**하는 객체이다.

### ItemWriter

+ 처리 된 Data를 **Writer 할 때 사용**한다. 
+ Writer는 처리 결과물에 따라 **Insert, Update, Send**가 될 수 있다.

### ItemProcessor

+ Reader에서 읽어온 Item을 **데이터 처리**하는 역할을 하고 있다.   

