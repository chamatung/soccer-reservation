import React, { useEffect } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import { Box, Container } from "@material-ui/core";
import StadiumList from "./StadiumList";
import { inject, observer } from "mobx-react";

const useStyles = makeStyles((theme) => ({
  container: {
    width: "100%",
    maxWidth: "100%",
    marginLeft: "auto",
    marginRight: "auto",
    margin: "0",
    padding: "0",
  },
  subHeader: {
    width: "100%",
    paddingBottom: 10,
    overflow: "hidden",
  },
  tabWrap: {
    display: "flex",
    alignItems: "center",
  },
  swipeTabs: {
    display: "flex",
    marginRight: 10,
    overflow: "hidden",
    textAlign: "center",
  },
  mainFilter: {
    display: "flex",
    alignItems: "center",
  },
  filterWrapper: {
    width: "100%",
    display: "flex",
    alignItems: "center",
  },
  filterItem: {
    display: "flex",
    alignItems: "center",
    marginRight: 10,
    cursor: "pointer",
  },
  filterItemArrow: {
    width: 24,
    marginRight: 4,
  },
}));

const SocialReservation = inject("reservationStore")(
  observer(({ reservationStore }) => {
    const classes = useStyles();
    const [value, setValue] = React.useState(0);

    const handleChange = (event, newValue) => {
      setValue(newValue);
    };

    useEffect(() => {
      reservationStore.init();
    }, []);

    const { nowDays, nextDays, nowMonth, nowYear, nextMonth, nextYear } =
      reservationStore;

    const gameListChange = (day, month, year) => {
      const dayInfo = {
        day: day,
        month: month,
        year: year,
      };
      reservationStore.searchGameList(dayInfo);
    };

    return (
      <Container className={classes.container}>
        <Box
          sx={{
            flexGrow: 1,
            maxWidth: { sx: "400" },
            bgcolor: "background.paper",
          }}
        >
          <Tabs
            value={value}
            onChange={handleChange}
            variant='scrollable'
            scrollButtons='on'
            aria-label='visible arrows tabs example'
          >
            {nowDays.map((nowDay, index) => {
              return (
                <Tab
                  label={nowDay.date + " " + nowDay.day}
                  onClick={() => gameListChange(nowDay.date, nowMonth, nowYear)}
                />
              );
            })}
            {nextDays?.map((nextDay, index) => {
              return (
                <Tab
                  label={nextDay.date + " " + nextDay.day}
                  onClick={() =>
                    gameListChange(nextDay.date, nextMonth, nextYear)
                  }
                />
              );
            })}
          </Tabs>
        </Box>
        <StadiumList />
      </Container>
    );
  })
);
export default SocialReservation;
