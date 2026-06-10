function [d] = distance(a,b)
    if length(a)==length(b)
        d=0;
        for i=1:length(a)
            d=d+power(a(i)-b(i),2);
        end
        d=sqrt(d);
    else
        error("Dimension mismatch")
    end
end

