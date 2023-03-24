import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import { Box, Container } from "@material-ui/core";
import StadiumList from "./StadiumList";

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

export default function SocialReservation() {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
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
          <Tab label='22 수' />
          <Tab label='23 목' />
          <Tab label='24 금' />
          <Tab label='25 토' />
          <Tab label='26 일' />
          <Tab label='25 토' />
          <Tab label='26 일' />
          <Tab label='25 토' />
          <Tab label='26 일' />
        </Tabs>
      </Box>
      <StadiumList />
    </Container>
  );
}
