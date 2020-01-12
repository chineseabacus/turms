import { im } from "./proto-bundle";
import TurmsNotification = im.turms.proto.TurmsNotification;
export default class TurmsError {
    private readonly _code;
    private readonly _reason;
    static URL_UNINITIALIZED: string;
    static CLIENT_ALREADY_CONNECTED: string;
    constructor(code: number, reason: string);
    get code(): number;
    get reason(): string;
    toString(): string;
    static fromNotification(notification: TurmsNotification): TurmsError;
    static fromCode(code: number): TurmsError;
}
