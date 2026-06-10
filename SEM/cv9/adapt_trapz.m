function [I,k] = adapt_trapz(f,a,b,maxlevel,tol)
       x0=[a;b];
       k=0;
       I=0;
        while ~isempty(x0) && maxlevel>=k
            Itmp=0;
            x1=[];
            d=[];
            clf;
            for i=(1:size(x0,2))
                I1=((x0(2,i)-x0(1,i))/2)*(f(x0(1,i))+f(x0(2,i)));
                m=(x0(1,i)+x0(2,i))/2;
                I2=((x0(2,i)-x0(1,i))/4)*(f(x0(1,i))+f(x0(2,i))+2*f(m));
                xline(m);
                if abs(I1-I2)<3*(x0(2,i)-x0(1,i))*tol
                    I=I+I2;
                else
                    Itmp=Itmp+I2;
                    x1(:,end+1)=[x0(1,i) m];
                    x1(:,end+1)=[m x0(2,i)];
                end
            end
            x0=x1
            k=k+1;
        end
        I=I+Itmp;
end