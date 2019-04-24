events = read();
updated = eval(events,
    as(
        strptime(get("timestamp"), "%m/%d/"),
        literal("_time")
    )
);

write(updated);