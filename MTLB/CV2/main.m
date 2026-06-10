clear
clc

%1
minmatrix=10;
maxmatrix=40;
C=randn(round(minmatrix+(maxmatrix-minmatrix)*rand()),round(minmatrix+(maxmatrix-minmatrix)*rand()),round(minmatrix+(maxmatrix-minmatrix)*rand()));
size(C);


%2
tmp1=0;
for i=1:numel(C)
    tmp1=tmp1+C(i);
end
tmp2=tmp1/numel(C);
tmp3=sum(C,'all')/numel(C);
%sum(sum(sum(C)))/numel(C);
%3
B=squeeze(C(1,:,:));
size(B);

B= B-((sum(B.')./length(sum(B))).'); 

%4
D=F1cv2(C);
