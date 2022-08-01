SELECT "LINEORDER"."LO_ORDERKEY" AS "LO_ORDERKEY","CUSTOMER"."C_CUSTKEY" AS "C_CUSTKEY","SUPPLIER"."S_SUPPKEY" AS "S_SUPPKEY" FROM "SSB"."LINEORDER" AS "LINEORDER" INNER JOIN "SSB"."CUSTOMER" AS "CUSTOMER" ON "CUSTOMER"."C_CUSTKEY" = "LINEORDER"."LO_CUSTKEY" LEFT JOIN "SSB"."SUPPLIER" AS "SUPPLIER" ON "SUPPLIER"."S_SUPPKEY" = "LINEORDER"."LO_SUPPKEY"