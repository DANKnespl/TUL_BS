clear
clc

a=(1:50)

b=(1:0.2:10)

A=ones(3:3)
B=zeros(3:3)
D=eye(3:3)

M=cat(2,A,B,D) %M=[A B D]

C= [1 -1 1; 1 -1 0; -1 0 1]

B1=inv(C)

C.*B1
C*B1

(M.')*(C.') %(M.')*(C) 

C(:,2)= rand(1,size(C,1))

C(1,:)= [3,5,-7]

C1= C(1,(end-1:end))

C(C>=0)=1
C(C<0)=rand(size(C(C<0)))