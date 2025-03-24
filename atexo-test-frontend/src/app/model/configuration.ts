export interface ConfigurationRule {

    criteriaType: string;
    length: number | null;
    prefix: string;
    suffix: string;
    dateFormat: string | null;
    rank: number;
    initialValue: number | null;
}
