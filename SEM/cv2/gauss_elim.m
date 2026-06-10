function [x, U] = gauss_elim(A,b)
    for i=1:length(A)
        [val, ind]=max(abs(A(i:end,i)))
        if val<eps
            error("I sense something singular about you ~ Solair of Astora, age of fire");
        end
        ind=ind-1+i;
        tmp=A(i,:);
        A(i,:)=A(ind,:);
        A(ind,:)=tmp;
        tmp=b(i);
        b(i)=b(ind);
        b(ind)=tmp;
        for j=i:length(A)
            if i~=j
                b(j)=b(j)-A(j,i)*(b(i)/A(i,i));
                A(j,:)=A(j,:)-A(j,i).*(A(i,:)./A(i,i));
            end
        end

    end
    U=A;
    for i=1:length(A)
        b(i)=b(i)/A(i,i);
        A(i,:)=A(i,:)./A(i,i);
        for j=1:i
            if i~=j
                b(j)=b(j)-A(j,i)*b(i);
                A(j,:)=A(j,:)-A(j,i).*A(i,:);
            end
        end
    end
    x=b;
end