function [bino,hyge] = binohygpdf(a,b,c,d)
bino=binopdf(a,b,c/d)
hyge=hygepdf(a,d,c,b)
end

