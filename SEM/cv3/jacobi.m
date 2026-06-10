function [x,flag,rr,it,rv] = jacobi(A,b,tol,maxit)
    x=b;
    rv=[];
    flag=1;
    for iter=(1:maxit)
        tmp=x;
        for i=(1:length(b))
            it=iter-1;
            sum1=0;
            sum2=0;
            for j=(1:i-1)
            sum1=A(i,j)*tmp(j)+sum1;
            end
            for j=(i+1:length(b))
            sum2=A(i,j)*tmp(j)+sum2;
            end
            x(i)=(1/A(i,i))*(b(i)-sum1-sum2);
        end
        rr=norm(b-A*x)/norm(b);
        rv(end+1)=rr;
        if rr<tol
            flag=0;
            break;
        end 
        if isnan(rr)||isinf(rr)
            flag=4;
            break;
        end
    end
    rv=rv.';
endí