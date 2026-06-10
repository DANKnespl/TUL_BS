clear
clc

%1
A= randn(10,20);
%2
B=round(A);
%3
C=sortrows(B.', 'descend').';
for l=1:size(B,2)
    for i=1:(size(B,2)-1)
        P=true;
        j=1;
        while P==true
            if (B(j,i)==B(j,i+1))
                if j==size(B,1)
                    P=false;
                else
                    j=j+1;
                end
            elseif (B(j,i)<B(j,i+1))
                tmp=B(:,i);
                B(:,i)=B(:,i+1);
                B(:,i+1)=tmp;
                P=false;
            else 
                P=false;
            end
        end
    end
end
B
mean(C==B,'all')

