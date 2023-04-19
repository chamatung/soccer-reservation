import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableRow,
  Paper,
  Button,
} from "@material-ui/core";
import { inject, observer } from "mobx-react";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

const StadiumList = inject("reservationStore")(
  observer(({ reservationStore }) => {
    const classes = useStyles();
    const { gameList } = reservationStore;
    console.log(gameList);

    const gameApplyAndCancel = (game) => {
      reservationStore.gameApplyAndCancel(game);
    };

    return (
      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label='list'>
          <TableBody>
            {gameList.map((game, index) => (
              <TableRow key={index}>
                <TableCell component='th' scope='row' align='center'>
                  {index + 1}
                </TableCell>

                <TableCell align='center'>{game.name}</TableCell>
                <TableCell align='center'>{game.startTime + " : 00"}</TableCell>
                <TableCell align='center'>
                  {!game.gameApplyCnt
                    ? "0 /" + game.totalMember
                    : game.gameApplyCnt + "/" + game.totalMember}
                </TableCell>
                <TableCell align='center'>
                  <Button
                    style={{
                      backgroundColor: game.email
                        ? "blue"
                        : game.gameApplyCnt > 1
                        ? "red"
                        : "green",
                      color: "white",
                    }}
                    onClick={() => {
                      gameApplyAndCancel(game);
                    }}
                  >
                    {game.email
                      ? "신청완료"
                      : game.status === "모집중" && game.gameApplyCnt > 1
                      ? "마감전"
                      : game.status}
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    );
  })
);
export default StadiumList;
