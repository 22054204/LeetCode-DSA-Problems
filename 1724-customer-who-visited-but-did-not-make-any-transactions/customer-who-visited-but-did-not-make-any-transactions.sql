# Write your MySQL query statement below
select t1.customer_id, Count(t1.customer_id) as count_no_trans from Visits t1
left join Transactions t2
on t1.visit_id = t2.visit_id
WHERE t2.transaction_id IS NULL
GROUP BY t1.customer_id;